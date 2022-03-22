package com.razal.lawyerappback;

import com.razal.lawyerappback.entity.Advokat;
import com.razal.lawyerappback.entity.Role;
import com.razal.lawyerappback.entity.Svojstvo;
import com.razal.lawyerappback.service.AdvokatService;
import com.razal.lawyerappback.service.KlijentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.razal.lawyerappback.enumeration.RoleType.ADMIN;
import static com.razal.lawyerappback.enumeration.RoleType.USER;

@SpringBootApplication
public class LawyerAppBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LawyerAppBackApplication.class, args);
    }

  /*  @Bean
    CommandLineRunner run(AdvokatService advokatService){
        return  args -> {

            Advokat a1 = new Advokat();
            a1.setBrojadvokatskelegitimacije(111);
            a1.setIme("Advokat1");
            a1.setPrezime("Advokatic1");
            a1.setKorisnickoime("admin");
            a1.setLozinka("admin");
            advokatService.saveAdvokat(a1);

            Advokat a2 = new Advokat();
            a2.setBrojadvokatskelegitimacije(222);
            a2.setIme("Advokat2");
            a2.setPrezime("Advokatic2");
            a2.setKorisnickoime("a1");
            a2.setLozinka("a1");
            advokatService.saveAdvokat(a2);


        };
    }*/

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
