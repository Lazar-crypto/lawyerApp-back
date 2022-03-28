package com.razal.lawyerappback.predmet.service.impl;

import com.razal.lawyerappback.predmet.entity.Predmet;
import com.razal.lawyerappback.predmet.repository.PredmetRepository;
import com.razal.lawyerappback.predmet.service.PredmetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PredmetServiceImpl implements PredmetService {

    final PredmetRepository repository;

    @Override
    public Predmet savePredmet(Predmet predmet){
        log.info("Saving Predmet: " + predmet.getNaziv());
        return repository.save(predmet);
    }

    @Override
    public List<Predmet> savePredmeti(List<Predmet> predmeti){
        log.info("Saving list of Predmet");
        return repository.saveAll(predmeti);
    }

    @Override
    public List<Predmet> getPredmeti(){
        log.info("Fethcing list of Predmet");
        return repository.findAll();
    }

    @Override
    public Predmet getPredmetById(int id){
        log.info("Fethcing Predmet by ID: " +id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Predmet getPredmetByName(String naziv){
        log.info("Fethcing Predmet by name: " +naziv);
        return repository.findByNaziv(naziv);
    }

    @Override
    public Boolean deletePredmet(int id){
        log.info("Deleting Predmet with ID: " +id);
        repository.deleteById(id);
        return TRUE;
    }

    @Override
    public Predmet updatePredmet(Predmet predmet){
        log.info("Updating Predmet: " +predmet.getNaziv());
        return repository.save(predmet);
    }

}
