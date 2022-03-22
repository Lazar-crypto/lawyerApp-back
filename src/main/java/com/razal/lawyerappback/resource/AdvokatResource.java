package com.razal.lawyerappback.resource;

import com.razal.lawyerappback.entity.Advokat;
import com.razal.lawyerappback.response.CustomResponse;
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
public class AdvokatResource {

    final AdvokatService service;

    /*@PostMapping("/addAdvokat")
    public Advokat addAdvokat(@Valid @RequestBody Advokat advokat){
        return service.saveAdvokat(advokat);
    }*/
    @PostMapping("/addAdvokat")
    public ResponseEntity<CustomResponse> addAdvokat(@RequestBody @Valid Advokat advokat){
        return ResponseEntity.ok(
                CustomResponse.builder()
                        .timeStamp(now())
                        .data(Map.of("advokat", service.saveAdvokat(advokat)))
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
    public ResponseEntity<CustomResponse> addAdvokatI(@RequestBody @Valid List<Advokat> advokati){
        return ResponseEntity.ok(
                CustomResponse.builder()
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
    public ResponseEntity<CustomResponse> getAdvokati(){
        return ResponseEntity.ok(
                CustomResponse.builder()
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
    public ResponseEntity<CustomResponse> getAdvokatById(@PathVariable int id){
        return ResponseEntity.ok(
                CustomResponse.builder()
                        .timeStamp(now())
                        .data(Map.of("advokat",service.getAdvokatByID(id)))
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
    public ResponseEntity<CustomResponse> getAdvokatByName(@PathVariable String name){
        return ResponseEntity.ok(
                CustomResponse.builder()
                        .timeStamp(now())
                        .data(Map.of("advokat",service.getAdvokatByUsername(name)))
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
    public ResponseEntity<CustomResponse> updateAdvokat(@Valid @RequestBody Advokat advokat){
        return ResponseEntity.ok(
                CustomResponse.builder()
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
    public ResponseEntity<CustomResponse> deleteAdvokat(@PathVariable int id){
        return ResponseEntity.ok(
                CustomResponse.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",service.deleteAdvokat(id)))
                        .msg("Advokat deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}

