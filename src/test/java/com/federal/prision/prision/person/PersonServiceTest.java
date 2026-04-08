package com.federal.prision.prision.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.federal.prision.address.Address;
import com.federal.prision.address.AddressService;
import com.federal.prision.address.dto.AddressDto;
import com.federal.prision.person.Person;
import com.federal.prision.person.PersonRepository;
import com.federal.prision.person.PersonService;
import com.federal.prision.person.dto.PersonDto;
import com.federal.prision.resource.exceptions.DatabaseException;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private AddressService addressService;

    @InjectMocks
    private PersonService personService;

    private PersonDto personDto;
    private Person person;
    private AddressDto addressDto;
    private Address address;

    @BeforeEach
    void setUp() {
        addressDto = new AddressDto(
                "Elm Street",
                "Apt 13",
                "CA",
                "Los Angeles",
                "USA",
                null
        );

        personDto = new PersonDto(
                "123-45-6789",
                LocalDate.of(1990, 5, 20),
                "John Doe",
                "john.doe@email.com",
                "Male"
        );
        personDto.setAddresses(List.of(addressDto));

        person = new Person();
        person.setId(1L);
        person.setSocialSecurity("123-45-6789");

        address = new Address();
    }

    // ✅ Fluxo feliz: pessoa e endereço criados com sucesso
    @Test
    void createPersonWithAddress_shouldCreatePersonAndAddress_whenDataIsValid() {
        when(personRepository.existsBySocialSecurity("123-45-6789")).thenReturn(false);
        when(personRepository.save(any(Person.class))).thenAnswer(invocation -> {
            Person p = invocation.getArgument(0);
            p.setId(1L); // simula o que o banco faria
            return p;
        });      
        when(addressService.fromDto(addressDto)).thenReturn(address);

        Person result = personService.createPersonWithAddress(personDto);

        assertNotNull(result);
        verify(personRepository, times(1)).save(any(Person.class));
        verify(addressService, times(1)).fromDto(addressDto);
        verify(addressService, times(1)).createAddress(eq(address), eq(person.getId()));
    }

    // ❌ Social Security duplicado deve lançar DatabaseException antes de salvar
    @Test
    void createPersonWithAddress_shouldThrowDatabaseException_whenSocialSecurityAlreadyExists() {
        when(personRepository.existsBySocialSecurity("123-45-6789")).thenReturn(true);

        DatabaseException exception = assertThrows(DatabaseException.class,
                () -> personService.createPersonWithAddress(personDto));

        assertEquals("Social Security already registered", exception.getMessage());
        verify(personRepository, never()).save(any());
        verify(addressService, never()).createAddress(any(), any());
    }

    // 📋 Múltiplos endereços: createAddress chamado uma vez por endereço
    @Test
    void createPersonWithAddress_shouldCallCreateAddress_forEachAddressInList() {
        AddressDto addressDto2 = new AddressDto(
                "Oak Avenue",
                null,
                "NY",
                "New York",
                "USA",
                null
        );
        Address address2 = new Address();
        personDto.setAddresses(List.of(addressDto, addressDto2));

        when(personRepository.existsBySocialSecurity(anyString())).thenReturn(false);
        when(personRepository.save(any(Person.class))).thenAnswer(invocation -> {
            Person p = invocation.getArgument(0);
            p.setId(1L); // simula o que o banco faria
            return p;
        });        when(addressService.fromDto(addressDto)).thenReturn(address);
        when(addressService.fromDto(addressDto2)).thenReturn(address2);

        personService.createPersonWithAddress(personDto);

        verify(addressService, times(2)).fromDto(any(AddressDto.class));
        verify(addressService, times(2)).createAddress(any(Address.class), eq(person.getId()));
    }

    // 📭 Lista vazia: nenhuma chamada ao AddressService
    @Test
    void createPersonWithAddress_shouldNotCallAddressService_whenAddressListIsEmpty() {
        personDto.setAddresses(List.of());

        when(personRepository.existsBySocialSecurity(anyString())).thenReturn(false);
        when(personRepository.save(any(Person.class))).thenAnswer(invocation -> {
            Person p = invocation.getArgument(0);
            p.setId(1L); // simula o que o banco faria
            return p;
        });
        Person result = personService.createPersonWithAddress(personDto);

        assertNotNull(result);
        verify(addressService, never()).fromDto(any());
        verify(addressService, never()).createAddress(any(), any());
    }

    // 💥 Falha no AddressService deve propagar a exceção
    @Test
    void createPersonWithAddress_shouldPropagateException_whenAddressServiceFails() {
        when(personRepository.existsBySocialSecurity(anyString())).thenReturn(false);
        when(personRepository.save(any(Person.class))).thenAnswer(invocation -> {
            Person p = invocation.getArgument(0);
            p.setId(1L); // simula o que o banco faria
            return p;
        });        when(addressService.fromDto(addressDto)).thenReturn(address);
        doThrow(new RuntimeException("Address creation failed"))
                .when(addressService).createAddress(any(), any());

        assertThrows(RuntimeException.class,
                () -> personService.createPersonWithAddress(personDto));
    }
}