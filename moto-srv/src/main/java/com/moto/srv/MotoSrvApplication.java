package com.moto.srv;

import com.moto.srv.entity.Moto;
import com.moto.srv.repository.MotoRepository;
import com.moto.srv.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MotoSrvApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MotoSrvApplication.class, args);
		ApplicationContext context = SpringApplication.run(MotoSrvApplication.class, args);
		MotoRepository repository = context.getBean(MotoRepository.class);
		Moto moto1 = new Moto(null,"Yamaha", "Y600", 2L);
		Moto moto2 = new Moto(null,"Kawasaki", "K350", 1L);
		Moto moto3 = new Moto(null,"Onda", "O500", 1L);
		Moto moto4 = new Moto(null,"Derbi", "D200", 2L);
		repository.save(moto1);
		repository.save(moto2);
		repository.save(moto3);
		repository.save(moto4);

	}

}
