package com.razal.lawyerappback.service;

import com.razal.lawyerappback.entity.Klijent;

import java.util.List;

public interface KlijentService {

    Klijent saveKlijent(Klijent klijent);

    List<Klijent> saveKlijenti(List<Klijent> klijenti);

    List<Klijent> getKlijenti();

    Klijent getKlijentByID(int id);

    Klijent getKlijentByName(String ime);

    String deleteKlijent(int id);

    Klijent updateKlijent(Klijent klijent);
}
