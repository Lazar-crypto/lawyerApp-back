package com.razal.lawyerappback.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "advokat")
public class Advokat {

    @Id
    @GeneratedValue
    int advokatID;

    int brojadvokatskelegitimacije;

    @Size(min = 3,message = "Ime mora imati bar tri slova!")
    String ime;
    String prezime;
    @NotEmpty(message = "Korisnicko ime ne sme biti prazno!")
    String korisnickoime;
    String lozinka;

    @OneToMany(fetch = LAZY, mappedBy = "advokat" , cascade = {DETACH, MERGE, PERSIST, REFRESH} )
    List<Predmet> predmeti;


}
