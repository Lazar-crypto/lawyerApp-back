package com.razal.lawyerappback.service;

import com.razal.lawyerappback.entity.Predmet;

import java.util.List;

public interface PredmetService {
    Predmet savePredmet(Predmet predmet);

    List<Predmet> savePredmeti(List<Predmet> predmeti);

    List<Predmet> getPredmeti();

    Predmet getPredmetById(int id);

    Predmet getPredmetByName(String naziv);

    String deletePredmet(int id);

    Predmet updatePredmet(Predmet predmet);
}
