package com.razal.lawyerappback.service;

import com.razal.lawyerappback.entity.Advokat;
import com.razal.lawyerappback.entity.Role;
import com.razal.lawyerappback.enumeration.RoleType;

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
