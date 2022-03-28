package com.razal.lawyerappback.predmet.resource;

import com.razal.lawyerappback.predmet.entity.Predmet;
import com.razal.lawyerappback.predmet.service.PredmetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/predmet")
@RestController
@RequiredArgsConstructor
public class PredmetResource {

    final PredmetService service;

    @PostMapping("/addPredmet")
    public Predmet addPredmet(@RequestBody Predmet predmet){
        return service.savePredmet(predmet);
    }

    @PostMapping("/addPredmeti")
    public List<Predmet> addPredmeti(@RequestBody List<Predmet> predmeti){
        return service.savePredmeti(predmeti);
    }

    @GetMapping("/predmeti")
    public List<Predmet> getPredmeti(){
        return service.getPredmeti();
    }

    @GetMapping("/predmetById/{id}")
    public Predmet getPredmetById(@PathVariable int id)  {
        return service.getPredmetById(id);
    }

    @GetMapping("/predmetByName/{name}")
    public Predmet getPredmetByName(@PathVariable String name){
        return service.getPredmetByName(name);
    }

    @PutMapping("/update")
    public Predmet updatePredmet(@RequestBody Predmet predmet){
        return service.updatePredmet(predmet);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteKlijent(@PathVariable int id){
        return service.deletePredmet(id);
    }

}
