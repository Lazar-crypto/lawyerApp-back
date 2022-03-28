package com.razal.lawyerappback.advokat.service;

import com.razal.lawyerappback.advokat.entity.Advokat;
import com.razal.lawyerappback.advokat.entity.Role;
import com.razal.lawyerappback.advokat.enumeration.RoleType;

import java.util.List;

public interface AdvokatService {

    Advokat saveAdvokat(Advokat advokat);

    List<Advokat> saveAdvokati(List<Advokat> advokati);

    List<Advokat> getAdvokati();

    Advokat getAdvokatByID(int id);

    Advokat getAdvokatByUsername(String username);

    Boolean deleteAdvokat(int id);

    Advokat updateAdvokat(Advokat advokat);

    Role getRole(RoleType type);

}
