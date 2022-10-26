package com.usuario.srv.controller;

import com.usuario.srv.dto.CarDTO;
import com.usuario.srv.dto.MotoDTO;
import com.usuario.srv.entity.UserDB;
import com.usuario.srv.service.UserDBService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserDBController {

    @Autowired
    private UserDBService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDB>> getAll(){
        List<UserDB> userDBS = userService.getAll();
        if(userDBS.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok (userDBS);
    }

    @GetMapping("/{id}")
    //@ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<UserDB> getById(@PathVariable Long id){
        UserDB userDB = userService.getById(id);
        //if(null == userDB) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDB);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDB> saveUsuario(@RequestBody UserDB user) {
        UserDB userDB = userService.saveUser(user);
        return ResponseEntity.ok(userDB);
    }

    @CircuitBreaker(name = "carsCB",fallbackMethod = "fallBackGetCars")
    @GetMapping("/cars/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CarDTO>> getCars(@PathVariable("userId") Long userId){
        UserDB userDB = userService.getById(userId);
        if(userDB ==null) return ResponseEntity.notFound().build();
        List<CarDTO> cars = userService.getCarByUserId(userId);
        return ResponseEntity.ok(cars);
    }

    @CircuitBreaker(name = "motosCB", fallbackMethod = "fallBackGetMotos")
    @GetMapping("/motos/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CarDTO>> getMotos(@PathVariable("userId") Long userId){
        UserDB userDB = userService.getById(userId);
        if(userDB ==null) return ResponseEntity.notFound().build();
        List<CarDTO> cars = userService.getCarByUserId(userId);
        return ResponseEntity.ok(cars);
    }

    @CircuitBreaker(name = "carsCB", fallbackMethod = "fallBackSaveCar")
    @PostMapping("/car/{userId}")
    public ResponseEntity<CarDTO> saveCar(
            @PathVariable("userId") Long id, @RequestBody CarDTO car){
        CarDTO carDTO = userService.saveCar(id, car);
        return ResponseEntity.ok(carDTO);
    }

    @CircuitBreaker(name = "allCB", fallbackMethod = "fallBackGetAll")
    @GetMapping("/allVehicles/{userId}")
    public ResponseEntity<Map<String, Object>> getAllVehicles(@PathVariable("userId") Long id){
        Map<String, Object> result = userService.getAllVehicles(id);
        return ResponseEntity.ok(result);
    }

    private ResponseEntity<List<CarDTO>> fallBackGetCars(@PathVariable("userId") Long id,
                                                          RuntimeException excepcion) {
        return new ResponseEntity("El usuario : " + id + " tiene los carros en el taller", HttpStatus.OK);
    }

    private ResponseEntity<CarDTO> fallBackSaveCar(@PathVariable("userId") Long id, @RequestBody CarDTO carDTO,
                                                    RuntimeException excepcion) {
        return new ResponseEntity("El usuario : " + id + " no tiene dinero para los carros", HttpStatus.OK);
    }

    private ResponseEntity<List<MotoDTO>> fallBackGetMotos(@PathVariable("userId") Long id, RuntimeException excepcion) {
        return new ResponseEntity("El usuario : " + id + " tiene las motos en el taller", HttpStatus.OK);
    }



    private ResponseEntity<Map<String, Object>> fallBackGetAll(@PathVariable("userId") Long id,
                                                                 RuntimeException excepcion) {
        return new ResponseEntity("El usuario : " + id + " tiene los vehiculos en el taller", HttpStatus.OK);
    }

}
