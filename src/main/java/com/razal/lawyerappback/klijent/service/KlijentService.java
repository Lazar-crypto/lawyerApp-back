package com.razal.lawyerappback.klijent.service;

import com.razal.lawyerappback.klijent.entity.Klijent;

import java.util.List;

public interface KlijentService {

    Klijent saveKlijent(Klijent klijent);

    List<Klijent> saveKlijenti(List<Klijent> klijenti);

    List<Klijent> getKlijenti();

    Klijent getKlijentByID(int id);

    Klijent getKlijentByName(String ime);

    Boolean deleteKlijent(int id);

    Klijent updateKlijent(Klijent klijent);
}
