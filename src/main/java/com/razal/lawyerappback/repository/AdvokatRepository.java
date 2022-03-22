package com.razal.lawyerappback.repository;

import com.razal.lawyerappback.entity.Advokat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvokatRepository extends JpaRepository<Advokat, Integer> {

    Advokat findByKorisnickoime(String username);
}
