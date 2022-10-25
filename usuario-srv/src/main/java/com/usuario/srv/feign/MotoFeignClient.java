package com.usuario.srv.feign;

import com.usuario.srv.dto.CarDTO;
import com.usuario.srv.dto.MotoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "moto-srv")
public interface MotoFeignClient {

    @PostMapping()
    MotoDTO save(@RequestBody MotoDTO motoDTO);

    @GetMapping("user/{userId}")
    List<MotoDTO> getMotos(@PathVariable("userId") Long id);

}
