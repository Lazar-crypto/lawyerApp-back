package com.razal.lawyerappback.service.impl;

import com.razal.lawyerappback.entity.Predmet;
import com.razal.lawyerappback.repository.PredmetRepository;
import com.razal.lawyerappback.service.PredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredmetServiceImpl implements PredmetService {

    @Autowired
    PredmetRepository repository;

    @Override
    public Predmet savePredmet(Predmet predmet){
        return repository.save(predmet);
    }

    @Override
    public List<Predmet> savePredmeti(List<Predmet> predmeti){
        return repository.saveAll(predmeti);
    }

    @Override
    public List<Predmet> getPredmeti(){
        return repository.findAll();
    }

    @Override
    public Predmet getPredmetById(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Predmet getPredmetByName(String naziv){
        return repository.findByNaziv(naziv);
    }

    @Override
    public String deletePredmet(int id){
        repository.deleteById(id);
        return "Predmet with id: " + id + "is deleted!";
    }

    @Override
    public Predmet updatePredmet(Predmet predmet){
        Predmet p = repository.findById(predmet.getPredmetID()).orElse(null);
        p.setNaziv(predmet.getNaziv());
        p.setProblem(predmet.getProblem());
        p.setDatum(predmet.getDatum());
        p.setAdvokat(predmet.getAdvokat());
        p.setKlijent(predmet.getKlijent());
        return repository.save(p);
    }

}
