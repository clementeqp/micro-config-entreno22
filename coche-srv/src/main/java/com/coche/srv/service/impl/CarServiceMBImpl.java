package com.coche.srv.service.impl;

import com.coche.srv.dto.CarDTO;
import com.coche.srv.dto.StandardMessage;
import com.coche.srv.entity.Car;
import com.coche.srv.repository.CarRepositoryMB;
import com.coche.srv.service.CarServiceMb;
import com.coche.srv.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarServiceMBImpl implements CarServiceMb {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    CarRepositoryMB carRepositoryMB;


    @Override
    public ResponseEntity<CarDTO> getById(UUID id) {
        CarDTO carDTO = modelMapper.map(carRepositoryMB.getById(id), CarDTO.class);
        if (Util.isNull(carDTO))
            return Util.createResponseEntity(null, HttpStatus.NOT_FOUND);
        return Util.createResponseEntity(carDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardMessage> createCar(CarDTO carDTO) {
        StandardMessage mensaje = new StandardMessage();
        Car carMapeado = modelMapper.map(carDTO, Car.class);
        //Car carMapeado=this.mapCarDTOToCar(carDTO);
        //carMapeado.setId(this.generateRandomUUID());
        System.out.println(carMapeado.getId());
        Integer rowsAffected = carRepositoryMB.createCar(carMapeado);
        if (rowsAffected <= 0) {
            mensaje.setMensaje("No se pudo crear.");
            return Util.createResponseEntity(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        mensaje.setMensaje("Creado con éxito.");
        return Util.createResponseEntity(mensaje, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<StandardMessage> deleteCar(UUID id) {
        StandardMessage mensaje = new StandardMessage();
        Integer rowsAffected = carRepositoryMB.deleteCar(id);
        if (rowsAffected <= 0) {
            mensaje.setMensaje("No se pudo borrar.");
            return Util.createResponseEntity(mensaje, HttpStatus.NOT_FOUND);
        }
        mensaje.setMensaje("Car Borrado");
        return Util.createResponseEntity(mensaje, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<StandardMessage> updateCar(CarDTO carDTO) {
        StandardMessage mensaje = new StandardMessage();
        Car carMapeado = modelMapper.map(carDTO, Car.class);
        Integer rowsAffected = carRepositoryMB.updateCar(carMapeado);
        if (rowsAffected <= 0) {
            mensaje.setMensaje("No se pudo actualizar.");
            return Util.createResponseEntity(mensaje, HttpStatus.NOT_FOUND);
        }
        mensaje.setMensaje("Actualizado con éxito.");
        return Util.createResponseEntity(mensaje, HttpStatus.CREATED);
    }
}
