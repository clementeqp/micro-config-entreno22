package com.coche.srv;

import com.coche.srv.entity.Car;
import com.coche.srv.repository.CarRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

import java.util.List;

@EnableEurekaClient
@SpringBootApplication
public class CarSrvApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CocheSrvApplication.class, args);
		ApplicationContext context = SpringApplication.run(CarSrvApplication.class, args);
		CarRepository repository = context.getBean(CarRepository.class);

		Car car1 = Car.builder().id(null).marca("Mercedes").modelo("E5").userId(2L).build();
		Car car2 = Car.builder().id(null).marca("Opel").modelo("O2").userId(1L).build();
		Car car3 = Car.builder().id(null).marca("Audi").modelo("A3").userId(1L).build();

		repository.saveAll(List.of(car1, car2, car3));
	}

}
