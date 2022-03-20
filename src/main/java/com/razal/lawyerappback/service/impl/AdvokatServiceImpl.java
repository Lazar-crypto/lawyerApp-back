package com.razal.lawyerappback.service.impl;

import com.razal.lawyerappback.entity.Advokat;
import com.razal.lawyerappback.repository.AdvokatRepository;
import com.razal.lawyerappback.service.AdvokatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AdvokatServiceImpl implements AdvokatService {

    final AdvokatRepository repository;

    @Override
    public Advokat saveAdvokat(Advokat advokat){
        log.info("Saving Advokat: " + advokat.getIme() + " " + advokat.getPrezime());
        return repository.save(advokat);
    }

    @Override
    public List<Advokat> saveAdvokati(List<Advokat> advokati){
        log.info("Saving list of Advokat");
        return repository.saveAll(advokati);
    }

    @Override
    public List<Advokat> getAdvokati(){
        log.info("Fethicng list of Advokat ");
        return repository.findAll();
    }

    @Override
    public Advokat getAdvokatByID(int id){
        log.info("Fethicng Advokat by ID ");
        return repository.findById(id).get();
    }

    @Override
    public Advokat getAdvokatByName(String ime){
        log.info("Fethcing Advokat by Name ");
        return repository.findByIme(ime);
    }

    @Override
    public Boolean deleteAdvokat(int id){
        log.info("Deleting Advokat with ID: " + id);
        repository.deleteById(id);
        return TRUE;
    }

    @Override
    public Advokat updateAdvokat(Advokat advokat){
       /* Advokat a = repository.findById(advokat.getAdvokatID()).orElse(null);
        a.setIme(advokat.getIme());
        a.setPrezime(advokat.getPrezime());
        a.setKorisnickoime(advokat.getKorisnickoime());
        a.setLozinka(advokat.getLozinka());
        a.setBrojadvokatskelegitimacije(advokat.getBrojadvokatskelegitimacije());*/
    //JPA zna kad mu prosledis id da treba update u suprotnom create
        log.info("Updating Advokat: " + advokat.getIme() + " " + advokat.getPrezime());
        return repository.save(advokat);
    }

}
