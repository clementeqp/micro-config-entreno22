package com.usuario.srv;



import com.usuario.srv.entity.UserDB;
import com.usuario.srv.repository.UserDBRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;


@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class UserSrvApplication {

	public static void main(String[] args) {
		//SpringApplication.run(UserSrvApplication.class, args);
		ApplicationContext context = SpringApplication.run(UserSrvApplication.class, args);
		UserDBRepository repository = context.getBean(UserDBRepository.class);


		UserDB user1 = new UserDB(null,"Paco", "paco@mail.es");
		UserDB user2 = new UserDB(null, "Juan", "juan@mail.es");
		repository.save(user1);
		repository.save(user2);
	}

}
