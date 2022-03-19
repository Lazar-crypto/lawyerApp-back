package com.razal.lawyerappback.service.impl;

import com.razal.lawyerappback.entity.Advokat;
import com.razal.lawyerappback.repository.AdvokatRepository;
import com.razal.lawyerappback.service.AdvokatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvokatServiceImpl implements AdvokatService {

    @Autowired
    private AdvokatRepository repository;

    @Override
    public Advokat saveAdvokat(Advokat advokat){
        return repository.save(advokat);
    }

    @Override
    public List<Advokat> saveAdvokati(List<Advokat> advokati){
        return repository.saveAll(advokati);
    }

    @Override
    public List<Advokat> getAdvokati(){
        return repository.findAll();
    }

    @Override
    public Advokat getAdvokatByID(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Advokat getAdvokatByName(String ime){
        return repository.findByIme(ime);
    }

    @Override
    public String deleteAdvokat(int id){
        repository.deleteById(id);
        return "Advokat with id: " + id + "is deleted!";
    }

    @Override
    public Advokat updateAdvokat(Advokat advokat){
        Advokat a = repository.findById(advokat.getAdvokatID()).orElse(null);
        a.setIme(advokat.getIme());
        a.setPrezime(advokat.getPrezime());
        a.setKorisnickoime(advokat.getKorisnickoime());
        a.setLozinka(advokat.getLozinka());
        a.setBrojadvokatskelegitimacije(advokat.getBrojadvokatskelegitimacije());
        return repository.save(a);
    }

}
