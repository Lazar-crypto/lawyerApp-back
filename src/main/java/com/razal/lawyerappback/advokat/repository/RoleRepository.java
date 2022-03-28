package com.razal.lawyerappback.advokat.repository;

import com.razal.lawyerappback.advokat.entity.Role;
import com.razal.lawyerappback.advokat.enumeration.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByRoleType(RoleType type);

}
