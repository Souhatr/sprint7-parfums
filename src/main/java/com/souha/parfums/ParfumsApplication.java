package com.souha.parfums;

import java.util.Date;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
/*import org.springframework.security.crypto.password.PasswordEncoder;*/

import com.souha.parfums.entities.Marque;
import com.souha.parfums.entities.Parfum;
/*import com.souha.parfums.entities.Role;
import com.souha.parfums.entities.User;
import com.souha.parfums.service.ParfumService;
/*import com.souha.parfums.service.UserService;*/

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ParfumsApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	/*@Autowired
	PasswordEncoder passwordEncoder;*/
	/*@Autowired
	UserService userService;*/
	
	public static void main(String[] args) {
		SpringApplication.run(ParfumsApplication.class, args);
	}
	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"souha","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("souha", "USER");
	userService.addRoleToUser("souha", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}
	*/
	@Override
	public void run(String... args) throws Exception {
		/*System.out.println("Password Encoded BCRYPT :******************** ");
		 System.out.println(passwordEncoder.encode("123"));*/
		
		repositoryRestConfiguration.exposeIdsFor(Parfum.class,Marque.class);
	}
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
	

}
