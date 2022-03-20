package com.razal.lawyerappback.service;

import com.razal.lawyerappback.entity.Advokat;

import java.util.List;

public interface AdvokatService {

    Advokat saveAdvokat(Advokat advokat);

    List<Advokat> saveAdvokati(List<Advokat> advokati);

    List<Advokat> getAdvokati();

    Advokat getAdvokatByID(int id);

    Advokat getAdvokatByName(String ime);

    Boolean deleteAdvokat(int id);

    Advokat updateAdvokat(Advokat advokat);
}
