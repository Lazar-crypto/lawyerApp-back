package com.razal.lawyerappback.repository;

import com.razal.lawyerappback.entity.Role;
import com.razal.lawyerappback.enumeration.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByRoleType(RoleType type);

}
