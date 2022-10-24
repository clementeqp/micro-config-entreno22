package com.moto.srv.controller;

import com.moto.srv.entity.Moto;
import com.moto.srv.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Moto> getMoto(@PathVariable Long id){
        Moto moto = motoService.getMoto(id);
        if (moto==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(moto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Moto>> getAll(){
        List<Moto> motos = motoService.getAll();
        if(motos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(motos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Moto> saveMoto(@RequestBody Moto moto){
       return ResponseEntity.ok(motoService.saveMoto(moto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Moto>> getCarsByUserId(@PathVariable("userId") Long id){
        List<Moto> motos = motoService.getMotosByUserId(id);
        if(motos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(motos);
    }

}
