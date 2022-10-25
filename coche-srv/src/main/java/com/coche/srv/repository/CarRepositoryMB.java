package com.coche.srv.repository;

import com.coche.srv.entity.Car;
import com.coche.srv.handlers.UUIDHandler;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Mapper
public interface CarRepositoryMB {

    @Select("SELECT id, marca, modelo, userId " +
            "FROM car " +
            "WHERE id=#{id}")
    @Result(property = "id", column = "id", typeHandler = UUIDHandler.class)
    Car getById(@Param("id") UUID id);

    @Insert("INSERT INTO car(id,marca, modelo, userId) VALUES (#{car.id},#{car.marca},#{.modelo},#{car.userId})")
    Integer createCar(@Param("car")Car car);

    @Delete("DELETE FROM car WHERE id=#{id}")
    Integer deleteCar(@Param("id") UUID id);

    @Update("UPDATE car SET marca=#{car.marca},modelo=#{car.modelo},userId= #{car.userId}")
    Integer updateCar(@Param("car")Car car);
}
