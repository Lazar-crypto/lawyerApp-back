package com.razal.lawyerappback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "klijent")
public class Klijent {
    @Id
    @GeneratedValue
    int klijentID;

    String ime;
    String prezime;
    Date datumrodjenja;
    String jmbg;
    String telefon;

    @JoinColumn(name = "svojstvoID")
    @ManyToOne(fetch = EAGER,cascade = ALL)
    Svojstvo svojstvo;

    @OneToMany(fetch = EAGER, mappedBy = "klijent" , cascade = {DETACH, MERGE, PERSIST, REFRESH} )
    List<Predmet> predmeti;


}
