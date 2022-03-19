package com.razal.lawyerappback.repository;

import com.razal.lawyerappback.entity.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredmetRepository extends JpaRepository<Predmet,Integer> {


    Predmet findByNaziv(String naziv);
}
