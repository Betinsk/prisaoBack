package com.federal.prision.inmate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmateRepository extends JpaRepository<Inmate, Long> {

	boolean existsBySocialSecurity(String socialSecurity);
}
