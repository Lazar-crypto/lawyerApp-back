package com.razal.lawyerappback.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Predmet {

    @Id
    @GeneratedValue(strategy = AUTO)
    int predmetID;
    String naziv;
    @Lob //more space
    String problem;
    Date datum;

    @JoinColumn(name="advokatID")
    @ManyToOne(fetch = EAGER,cascade = {DETACH, MERGE, PERSIST, REFRESH})
    Advokat advokat;

    @JoinColumn(name = "klijentID")
    @ManyToOne(fetch = EAGER,cascade = {DETACH, MERGE, PERSIST, REFRESH})
    Klijent klijent;



}
