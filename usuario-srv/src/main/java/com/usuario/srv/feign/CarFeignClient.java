package com.usuario.srv.feign;

import com.usuario.srv.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "car-srv", url = "http://localhost:8002/car")
public interface CarFeignClient {

    @PostMapping()
    CarDTO save(@RequestBody CarDTO carDTO);

    @GetMapping("user/{userId}")
    List<CarDTO> getCars(@PathVariable("userId") Long id);

}
