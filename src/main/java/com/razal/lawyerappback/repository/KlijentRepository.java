package com.razal.lawyerappback.repository;

import com.razal.lawyerappback.entity.Klijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlijentRepository extends JpaRepository<Klijent,Integer> {

    Klijent findByIme(String ime);
}
