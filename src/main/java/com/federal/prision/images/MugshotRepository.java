package com.federal.prision.images;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MugshotRepository extends JpaRepository<Mugshot, Long> {

}
