package com.razal.lawyerappback.predmet.service;

import com.razal.lawyerappback.predmet.entity.Predmet;

import java.util.List;

public interface PredmetService {
    Predmet savePredmet(Predmet predmet);

    List<Predmet> savePredmeti(List<Predmet> predmeti);

    List<Predmet> getPredmeti();

    Predmet getPredmetById(int id);

    Predmet getPredmetByName(String naziv);

    Boolean deletePredmet(int id);

    Predmet updatePredmet(Predmet predmet);
}
