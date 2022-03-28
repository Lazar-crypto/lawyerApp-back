package com.razal.lawyerappback.klijent.repository;

import com.razal.lawyerappback.klijent.entity.Klijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlijentRepository extends JpaRepository<Klijent,Integer> {

    Klijent findByIme(String ime);
}
