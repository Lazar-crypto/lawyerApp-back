package com.razal.lawyerappback.klijent.resource;

import com.razal.lawyerappback.klijent.entity.Klijent;
import com.razal.lawyerappback.klijent.service.KlijentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/klijent")
@RestController
@RequiredArgsConstructor
public class KlijentResource {

    final KlijentService service;

    @PostMapping("/addKlijent")
    public Klijent addAdvokat(@RequestBody Klijent klijent){
        return service.saveKlijent(klijent);
    }

    @PostMapping("/addKlijenti")
    public List<Klijent> addKlijenti(@RequestBody List<Klijent> klijenti){
        return service.saveKlijenti(klijenti);
    }

    @GetMapping("/klijenti")
    public List<Klijent> getKlijenti(){
        return service.getKlijenti();
    }

    @GetMapping("/klijentById/{id}")
    public Klijent getKlijentById(@PathVariable int id){
        return service.getKlijentByID(id);
    }

    @GetMapping("/klijentByName/{name}")
    public Klijent getKlijentByName(@PathVariable String name){
        return service.getKlijentByName(name);
    }

    @PutMapping("/update")
    public Klijent updateKlijent(@RequestBody Klijent klijent){
        return service.updateKlijent(klijent);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteKlijent(@PathVariable int id){
        return service.deleteKlijent(id);
    }


}
