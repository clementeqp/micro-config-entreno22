package com.usuario.srv;



import com.usuario.srv.entity.UserDB;
import com.usuario.srv.repository.UserDBRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.cert.Extension;


@EnableFeignClients
@SpringBootApplication
public class UserSrvApplication {

	public static void main(String[] args) {
		//SpringApplication.run(UserSrvApplication.class, args);
		ApplicationContext context = SpringApplication.run(UserSrvApplication.class, args);
		UserDBRepository repository = context.getBean(UserDBRepository.class);

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String adminEncoder = bCryptPasswordEncoder.encode("admin");
		String userEncoder = bCryptPasswordEncoder.encode("user");

		UserDB user1 = new UserDB(null,"Paco", "paco@mail.es", adminEncoder);
		UserDB user2 = new UserDB(null, "Juan", "juan@mail.es", userEncoder);
		repository.save(user1);
		repository.save(user2);

	}

}
