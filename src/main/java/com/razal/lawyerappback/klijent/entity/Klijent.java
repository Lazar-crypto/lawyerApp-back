package com.razal.lawyerappback.klijent.entity;

import com.razal.lawyerappback.predmet.entity.Predmet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Klijent {
    @Id
    @GeneratedValue(strategy = AUTO)
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
