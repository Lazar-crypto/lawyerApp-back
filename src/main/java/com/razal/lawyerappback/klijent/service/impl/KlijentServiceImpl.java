package com.razal.lawyerappback.klijent.service.impl;

import com.razal.lawyerappback.klijent.entity.Klijent;
import com.razal.lawyerappback.klijent.repository.KlijentRepository;
import com.razal.lawyerappback.klijent.service.KlijentService;
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
public class KlijentServiceImpl implements KlijentService {

    final KlijentRepository repository;

    @Override
    public Klijent saveKlijent(Klijent klijent){
        log.info("Saving Klijent: " + klijent.getIme() + " " + klijent.getPrezime());
        return repository.save(klijent);
    }

    @Override
    public List<Klijent> saveKlijenti(List<Klijent> klijenti){
        log.info("Saving list of Klijent");
        return repository.saveAll(klijenti);
    }

    @Override
    public List<Klijent> getKlijenti(){
        log.info("Fetching list of Klijent");
        return repository.findAll();
    }

    @Override
    public Klijent getKlijentByID(int id){
        log.info("Fetching Klijent by ID: " + id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Klijent getKlijentByName(String ime){
        log.info("Fething Klijent by name: "+ ime);
        return repository.findByIme(ime);
    }

    @Override
    public Boolean deleteKlijent(int id){
        log.info("Deleting Klijent with ID: "+id);
        repository.deleteById(id);
        return TRUE;
    }

    @Override
    public Klijent updateKlijent(Klijent klijent){
        log.info("Updating klijent: "+klijent.getIme() + " " + klijent.getPrezime());
        return repository.save(klijent);
    }

}
