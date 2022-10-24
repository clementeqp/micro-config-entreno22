package com.usuario.srv.controller;

import com.usuario.srv.dto.CarDTO;
import com.usuario.srv.entity.UserDB;
import com.usuario.srv.service.UserDBService;
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
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDB> getById(@PathVariable Long id){
        UserDB userDB = userService.getById(id);
        if(null == userDB) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDB);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDB> saveUsuario(@RequestBody UserDB user) {
        UserDB userDB = userService.saveUser(user);
        return ResponseEntity.ok(userDB);
    }

    @GetMapping("/cars/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CarDTO>> getCars(@PathVariable("userId") Long userId){
        UserDB userDB = userService.getById(userId);
        if(userDB ==null) return ResponseEntity.notFound().build();
        List<CarDTO> cars = userService.getCarByUserId(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/motos/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CarDTO>> getMotos(@PathVariable("userId") Long userId){
        UserDB userDB = userService.getById(userId);
        if(userDB ==null) return ResponseEntity.notFound().build();
        List<CarDTO> cars = userService.getCarByUserId(userId);
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/car/{userId}")
    public ResponseEntity<CarDTO> saveCar(
            @PathVariable("userId") Long id, @RequestBody CarDTO car){
        CarDTO carDTO = userService.saveCar(id, car);
        return ResponseEntity.ok(carDTO);
    }

    @GetMapping("/allVehicles/{userId}")
    public ResponseEntity<Map<String, Object>> getAllVehicles(@PathVariable("userId") Long id){
        Map<String, Object> result = userService.getAllVehicles(id);
        return ResponseEntity.ok(result);
    }

}
