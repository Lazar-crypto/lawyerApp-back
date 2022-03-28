package com.razal.lawyerappback.advokat.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.razal.lawyerappback.predmet.entity.Predmet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advokat {

    @Id
    @GeneratedValue(strategy = AUTO)
    int advokatID;

    int brojadvokatskelegitimacije;

    @Size(min = 3,message = "Ime mora imati bar tri slova!")
    String ime;
    String prezime;
    @NotEmpty(message = "Korisnicko ime ne sme biti prazno!")
    String korisnickoime;
    String lozinka;

    @JsonInclude(NON_NULL) //posto ne pripada tabeli vrati ga kao response samo ako nije null
    @OneToMany(fetch = LAZY, mappedBy = "advokat" , cascade = {DETACH, MERGE, PERSIST, REFRESH} )
    List<Predmet> predmeti;

    //for spring security
    @JoinColumn(name = "roleID")
    @ManyToOne(fetch = EAGER)
    Role role;
    //String[] authorities;
    //boolean isNotLocked; //kad se registuje bice locked i salje se mejl
    //boolean isEnabled;// otkljucan za koriscenje


}
