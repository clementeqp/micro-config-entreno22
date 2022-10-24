package com.coche.srv.service;


import com.coche.srv.entity.Car;
import com.coche.srv.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car getCar(Long id){
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getAll(){
        return carRepository.findAll();
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public List<Car> getCarByUserId(Long id){
        return carRepository.findByUserId(id);
    }
}
