package com.razal.lawyerappback.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "svojstvo")
public class Svojstvo {
    @Id
    @GeneratedValue
    int svojstvoID;

    @Enumerated(EnumType.STRING)
    @Column(name = "naziv")
    SvojstvoType naziv;
}
