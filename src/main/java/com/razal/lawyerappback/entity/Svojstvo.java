package com.razal.lawyerappback.entity;


import com.razal.lawyerappback.enumeration.SvojstvoType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Svojstvo {
    @Id
    @GeneratedValue(strategy = AUTO)
    int svojstvoID;

    @Enumerated(EnumType.STRING)
    @Column(name = "naziv")
    SvojstvoType naziv;
}
