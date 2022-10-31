package com.usuario.srv.service;

import com.google.gson.Gson;
import com.usuario.srv.dto.CarDTO;
import com.usuario.srv.dto.MotoDTO;
import com.usuario.srv.entity.UserDB;
import com.usuario.srv.feign.CarFeignClient;
import com.usuario.srv.feign.MotoFeignClient;
import com.usuario.srv.repository.UserDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserDBService {

    //RestTemplate
    @Autowired
    private RestTemplate restTemplate;
    //Feign
    @Autowired
    private CarFeignClient carFeignClient;
    @Autowired
    private MotoFeignClient motoFeignClient;

    //TODO MotoFeignClient

    @Autowired
    private UserDBRepository userDBRepository;

    @Autowired
    private UserDBEventService userEventsService;

 /*   public UserDBService(UserEventService userEventsService) {
        super();
        this.userEventsService = userEventsService;
    }*/



    public List<UserDB> getAll(){
        return userDBRepository.findAll();
    }

    public UserDB getById(Long id){
        return userDBRepository.findById(id).orElse(null);
    }
    public UserDB saveUser(UserDB userDB){
        save(userDB);
        return userDBRepository.saveAndFlush(userDB);
    }

    public List<CarDTO> getCarByUserId(Long userId) {
        return restTemplate.getForObject("http://localhost:8002/car/user/" + userId, List.class);
    }

    public List<CarDTO> getMotoByUserId(Long userId) {
        return restTemplate.getForObject("http://localhost:8003/moto/user/" + userId, List.class);
    }

    public CarDTO saveCar(Long userId, CarDTO carDTO){
        carDTO.setUserId(userId);
        return carFeignClient.save(carDTO);
    }

    public Map<String, Object> getAllVehicles(Long userId){
        Map<String, Object> result = new HashMap<>();
        UserDB user = userDBRepository.findById(userId).orElse(null);
        if(user==null){
            result.put("Mensaje", "El usuario no existe");
            return result;
        }
        result.put("Usuario", user);
        List<CarDTO> cars = carFeignClient.getCars(userId);
        if(cars.isEmpty()){
            result.put("Coches", "El usuario no tiene coches");
        }
        else{
            result.put("Coches", cars);
        }
        List < MotoDTO> motos = motoFeignClient.getMotos(userId);
        if(motos.isEmpty()){
            result.put("Motos", "El usuario no tiene motos");
        }
        else{
            result.put("Motos", motos);
        }
        return result;
    }

    public void save(UserDB user) {
        Gson gson = new Gson();
        System.out.println("Received: " + gson.toJson(user) );
        this.userEventsService.publish(user);

    }
}
