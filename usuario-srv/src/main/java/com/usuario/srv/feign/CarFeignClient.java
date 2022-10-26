package com.usuario.srv.feign;

import com.usuario.srv.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-srv", path = "/car")
public interface CarFeignClient {

    @PostMapping()
    CarDTO save(@RequestBody CarDTO carDTO);

    @GetMapping("/user/{userId}")
    List<CarDTO> getCars(@PathVariable("userId") Long id);

}
