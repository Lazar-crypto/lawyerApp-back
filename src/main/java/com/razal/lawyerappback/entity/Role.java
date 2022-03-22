package com.razal.lawyerappback.entity;

import com.razal.lawyerappback.enumeration.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = AUTO)
    int roleID;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    RoleType roleType;

}
