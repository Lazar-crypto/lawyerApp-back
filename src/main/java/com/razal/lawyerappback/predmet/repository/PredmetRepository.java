package com.razal.lawyerappback.predmet.repository;

import com.razal.lawyerappback.predmet.entity.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredmetRepository extends JpaRepository<Predmet,Integer> {


    Predmet findByNaziv(String naziv);
}
