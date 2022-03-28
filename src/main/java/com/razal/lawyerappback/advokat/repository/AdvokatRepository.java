package com.razal.lawyerappback.advokat.repository;

import com.razal.lawyerappback.advokat.entity.Advokat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvokatRepository extends JpaRepository<Advokat, Integer> {

    Advokat findByKorisnickoime(String username);
}
