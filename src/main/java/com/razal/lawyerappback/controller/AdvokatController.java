package com.razal.lawyerappback.controller;

import com.razal.lawyerappback.entity.Advokat;
import com.razal.lawyerappback.entity.Response;
import com.razal.lawyerappback.exception.custom.NotFoundException;
import com.razal.lawyerappback.service.AdvokatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/advokat")
@RestController
@RequiredArgsConstructor
public class AdvokatController {

    final AdvokatService service;

    /*@PostMapping("/addAdvokat")
    public Advokat addAdvokat(@Valid @RequestBody Advokat advokat){
        return service.saveAdvokat(advokat);
    }*/
    @PostMapping("/addAdvokat")
    public ResponseEntity<Response> addAdvokat(@RequestBody @Valid Advokat advokat){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("advokat",service.saveAdvokat(advokat)))
                        .msg("Advokat created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }


    /*@PostMapping("/addAdvokati")
    public List<Advokat> addAdvokati(@RequestBody List<Advokat> advokati){
        return service.saveAdvokati(advokati);
    }*/
    @PostMapping("/addAdvokati")
    public ResponseEntity<Response> addAdvokatI(@RequestBody @Valid List<Advokat> advokati){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("advokati",service.saveAdvokati(advokati)))
                        .msg("Advokati created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }


    /*@GetMapping("/advokati")
    public List<Advokat> getAdvokati(){
        return service.getAdvokati();
    }*/
    @GetMapping("/advokati")
    public ResponseEntity<Response> getAdvokati(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("advokati",service.getAdvokati()))
                        .msg("Advokati retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    /*@GetMapping("/advokatById/{id}")
    public Advokat getAdvokatById(@PathVariable int id){
        Advokat advokat = service.getAdvokatByID(id);
        if(advokat == null)
            throw new NotFoundException("Advokat with id: " + id + " doesnt exist!");
        return advokat;
    }*/
    @GetMapping("/advokatById/{id}")
    public ResponseEntity<Response> getAdvokatById(@PathVariable int id){
        Advokat advokat = service.getAdvokatByID(id);
        if(advokat == null)
            throw new NotFoundException("Advokat with id: " + id + " doesnt exist!");

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("advokat",advokat))
                        .msg("Advokat with id: "+id+" retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    /*@GetMapping("/advokatByName/{name}")
    public Advokat getAdvokatByName(@PathVariable String name){
         Advokat advokat = service.getAdvokatByName(name);
        if(advokat == null)
            throw new NotFoundException("Advokat whose name is : '" + name + "' doesnt exist!");
        return advokat;
    }*/
    @GetMapping("/advokatByName/{name}")
    public ResponseEntity<Response> getAdvokatByName(@PathVariable String name){
        Advokat advokat = service.getAdvokatByName(name);
        if(advokat == null)
            throw new NotFoundException("Advokat whose name is : '" + name + "' doesnt exist!");

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("advokat",advokat))
                        .msg("Advokat whose name is: "+name+" retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    /*@PutMapping("/update")
    public Advokat updateAdvokat(@Valid @RequestBody Advokat advokat){
    return service.updateAdvokat(advokat);
    }*/
    @PutMapping("/update")
    public ResponseEntity<Response> updateAdvokat(@Valid @RequestBody Advokat advokat){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("updated",service.updateAdvokat(advokat)))
                        .msg("Advokat updated")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    /*@DeleteMapping("/delete/{id}")
    public Boolean deleteAdvokat(@PathVariable int id){
        return service.deleteAdvokat(id);
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteAdvokat(@PathVariable int id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",service.deleteAdvokat(id)))
                        .msg("Advokat deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}

