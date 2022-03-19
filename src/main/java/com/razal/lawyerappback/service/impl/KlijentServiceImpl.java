package com.razal.lawyerappback.service.impl;

import com.razal.lawyerappback.entity.Klijent;
import com.razal.lawyerappback.repository.KlijentRepository;
import com.razal.lawyerappback.service.KlijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlijentServiceImpl implements KlijentService {

    @Autowired
    KlijentRepository repository;

    @Override
    public Klijent saveKlijent(Klijent klijent){
        return repository.save(klijent);
    }

    @Override
    public List<Klijent> saveKlijenti(List<Klijent> klijenti){
        return repository.saveAll(klijenti);
    }

    @Override
    public List<Klijent> getKlijenti(){
        return repository.findAll();
    }

    @Override
    public Klijent getKlijentByID(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Klijent getKlijentByName(String ime){
        return repository.findByIme(ime);
    }

    @Override
    public String deleteKlijent(int id){
        repository.deleteById(id);
        return "Klijent with id: " + id + "is deleted!";
    }

    @Override
    public Klijent updateKlijent(Klijent klijent){
        Klijent k = repository.findById(klijent.getKlijentID()).orElse(null);
        k.setIme(klijent.getIme());
        k.setPrezime(klijent.getPrezime());
        k.setDatumrodjenja(klijent.getDatumrodjenja());
        k.setJmbg(klijent.getJmbg());
        k.setTelefon(klijent.getTelefon());
        k.setSvojstvo(klijent.getSvojstvo());
        return repository.save(k);
    }

}
