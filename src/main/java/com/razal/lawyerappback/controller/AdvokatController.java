package com.razal.lawyerappback.controller;

import com.razal.lawyerappback.entity.Advokat;
import com.razal.lawyerappback.exception.custom.NotFoundException;
import com.razal.lawyerappback.service.AdvokatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/advokat")
@RestController
public class AdvokatController {

    @Autowired
    AdvokatService service;

    @PostMapping("/addAdvokat")
    public Advokat addAdvokat(@Valid @RequestBody Advokat advokat){
        return service.saveAdvokat(advokat);
    }

    @PostMapping("/addAdvokati")
    public List<Advokat> addAdvokati(@RequestBody List<Advokat> advokati){
        return service.saveAdvokati(advokati);
    }

    @GetMapping("/advokati")
    public List<Advokat> getAdvokati(){
        return service.getAdvokati();
    }

    @GetMapping("/advokatById/{id}")
    public Advokat getAdvokatById(@PathVariable int id){
        Advokat advokat = service.getAdvokatByID(id);
        if(advokat == null)
            throw new NotFoundException("Advokat with id: " + id + " doesnt exist!");
        return advokat;
    }

    @GetMapping("/advokatByName/{name}")
    public Advokat getAdvokatByName(@PathVariable String name){
         Advokat advokat = service.getAdvokatByName(name);
        if(advokat == null)
            throw new NotFoundException("Advokat whose name is : '" + name + "' doesnt exist!");
        return advokat;
    }

    @PutMapping("/update")
    public Advokat updateAdvokat(@Valid @RequestBody Advokat advokat){
    return service.updateAdvokat(advokat);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdvokat(@PathVariable int id){
        return service.deleteAdvokat(id);
    }
}
