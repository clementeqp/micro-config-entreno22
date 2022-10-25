package com.coche.srv.controller;

import com.coche.srv.dto.CarDTO;
import com.coche.srv.dto.StandardMessage;
import com.coche.srv.service.impl.CarServiceMBImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/carMB")
public class CarControllerMB {

    @Autowired
    private CarServiceMBImpl carServiceMB;


    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable("id") UUID id){
        return carServiceMB.getById(id);
    }
    @PostMapping
    public ResponseEntity<StandardMessage> createCar(@RequestBody CarDTO carDTO){
        return carServiceMB.createCar(carDTO);
    }
    @PutMapping
    public ResponseEntity<StandardMessage> updateCar(@RequestBody CarDTO carDTO){
        return carServiceMB.updateCar(carDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardMessage> deleteCar(@PathVariable("id") UUID id){
        return carServiceMB.deleteCar(id);
    }
}