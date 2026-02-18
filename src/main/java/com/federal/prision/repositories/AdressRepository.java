package com.federal.prision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.federal.prision.domain.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {

}
