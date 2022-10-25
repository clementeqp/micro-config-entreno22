package com.coche.srv.service;

import com.coche.srv.dto.CarDTO;
import com.coche.srv.entity.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CarServiceMb {

    public ResponseEntity getById(UUID id);
    public ResponseEntity createCar(CarDTO carDTO);
    public ResponseEntity deleteCar(UUID id);
    public ResponseEntity updateCar(CarDTO carDTO);
}
