package com.coche.srv.controller;

import com.coche.srv.entity.Car;
import com.coche.srv.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Car> getCar(@PathVariable Long id){
        Car car = carService.getCar(id);
        if (car==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(car);
    }


    //Paginacion, necesita Spring Data y Web
    @GetMapping
    public ResponseEntity<Page<Car>> getAllPage(@PageableDefault(size=2, page=0) Pageable pageable){
        Page<Car> cars = carService.getAllPage(pageable);
        if(cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        List<Car> cars = carService.getAll();
        if(cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
       return ResponseEntity.ok(carService.saveCar(car));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Car>> getCarsByUserId(@PathVariable("userId") Long id){
        List<Car> cars = carService.getCarByUserId(id);
        if(cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }

}
