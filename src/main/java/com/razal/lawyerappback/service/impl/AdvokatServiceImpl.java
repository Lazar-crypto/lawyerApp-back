package com.razal.lawyerappback.service.impl;

import com.razal.lawyerappback.entity.Advokat;
import com.razal.lawyerappback.entity.Role;
import com.razal.lawyerappback.enumeration.RoleType;
import com.razal.lawyerappback.exception.custom.NotFoundException;
import com.razal.lawyerappback.repository.AdvokatRepository;
import com.razal.lawyerappback.repository.RoleRepository;
import com.razal.lawyerappback.service.AdvokatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.razal.lawyerappback.enumeration.RoleType.ADMIN;
import static com.razal.lawyerappback.enumeration.RoleType.USER;
import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AdvokatServiceImpl implements AdvokatService, UserDetailsService {

    final AdvokatRepository advokatRepository;
    final RoleRepository roleRepository;
    final PasswordEncoder passwordEncoder;

    //from UserDetailsService to load users from db
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Advokat advokat = getAdvokatByUsername(username);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(advokat.getRole().getRoleType().toString()));
        return new User(advokat.getKorisnickoime(),advokat.getLozinka(),authorities);
    }

    @Override
    public Advokat saveAdvokat(Advokat advokat){
        Role role;
        if(advokat.getKorisnickoime().equals("admin"))
             role = getRole(ADMIN);
        else
            role = getRole(USER);
        advokat.setRole(role);
        advokat.setLozinka(passwordEncoder.encode(advokat.getLozinka()));
        log.info("Saving Advokat: " + advokat.getIme() + " " + advokat.getPrezime());
        return advokatRepository.save(advokat);
    }

    @Override
    public List<Advokat> saveAdvokati(List<Advokat> advokati){
        log.info("Saving list of Advokat");
        advokati.forEach(advokat -> advokat.setLozinka(passwordEncoder.encode(advokat.getLozinka())));
        return advokatRepository.saveAll(advokati);
    }

    @Override
    public List<Advokat> getAdvokati(){
        log.info("Fethicng list of Advokat ");
        return advokatRepository.findAll();
    }

    @Override
    public Advokat getAdvokatByID(int id){
        Advokat advokat = advokatRepository.findById(id).orElse(null);
        if(advokat == null)
            throw new NotFoundException("Advokat with id: " + id + " doesnt exist!");
        log.info("Fethicng Advokat by ID ");
        return advokat;
    }

    @Override
    public Advokat getAdvokatByUsername(String username){
        Advokat advokat = advokatRepository.findByKorisnickoime(username);
        if(advokat == null)
            throw new NotFoundException("Advokat whose name is : '" + username + "' doesnt exist!");
        log.info("Fethcing Advokat by username: {}",username);
        return advokat;
    }

    @Override
    public Boolean deleteAdvokat(int id){
        log.info("Deleting Advokat with ID: " + id);
        advokatRepository.deleteById(id);
        return TRUE;
    }

    @Override
    public Advokat updateAdvokat(Advokat advokat){
       /* Advokat a = repository.findById(advokat.getAdvokatID()).orElse(null);
        a.setIme(advokat.getIme());
        a.setPrezime(advokat.getPrezime());
        a.setKorisnickoime(advokat.getKorisnickoime());
        a.setLozinka(advokat.getLozinka());
        a.setBrojadvokatskelegitimacije(advokat.getBrojadvokatskelegitimacije());*/
    //JPA zna kad mu prosledis id da treba update u suprotnom create
        log.info("Updating Advokat: " + advokat.getIme() + " " + advokat.getPrezime());
        return advokatRepository.save(advokat);
    }

    @Override
    public Role getRole(RoleType type) {
        log.info("Fethicng RoleType: " + type);
        return roleRepository.findByRoleType(type);
    }

}
