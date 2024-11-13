package com.ghizlen.coffee;

import com.ghizlen.coffee.entities.Coffee;
import com.ghizlen.coffee.entities.TypeCo;


//import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.security.crypto.password.PasswordEncoder;

//import com.souleimen.avions.service.UserService;

import jakarta.annotation.PostConstruct;
//import service.com.ghizlen.coffee.CoffeeService;

@SpringBootApplication
public class CoffeesApplication implements CommandLineRunner {
/*
	@Autowired
	CoffeeService avionService;
*/
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	//@Autowired
	//PasswordEncoder passwordEncoder;
	
//	@Autowired
//	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CoffeesApplication.class, args);
	}

	@PostConstruct
	void init_users() {
//		User user=userService.findUserByUsername("user1");
//		user.setPassword("456");
//		user.setPassword("123");
//		userService.saveUser(user);
		
		
		/*
		 * //ajouter les rôles userService.addRole(new Role(null,"ADMIN"));
		 * userService.addRole(new Role(null,"AGENT")); userService.addRole(new
		 * Role(null,"USER")); //ajouter les users userService.saveUser(new
		 * User(null,"admin","123",true,null)); userService.saveUser(new
		 * User(null,"souleimen","123",true,null)); userService.saveUser(new
		 * User(null,"user1","123",true,null)); //ajouter les rôles aux users
		 * userService.addRoleToUser("admin", "ADMIN");
		 * userService.addRoleToUser("souleimen", "USER");
		 * userService.addRoleToUser("souleimen", "AGENT");
		 * userService.addRoleToUser("user1", "USER");
		 */
	}

	
	@Override
	public void run(String... args) throws Exception {
		
//		 System.out.println("Password Encoded BCRYPT :******************** ");
//		 System.out.println(passwordEncoder.encode("123"));

				
		/*
		avionService.saveAvion(new Coffee("Boeing233", 5422600, new Date()));
		avionService.saveAvion(new Coffee("Airline231", 212800, new Date()));
		avionService.saveAvion(new Coffee("Skyflight242", 1119900, new Date()));
		*/
	
		repositoryRestConfiguration.exposeIdsFor(Coffee.class, TypeCo.class);

}
	
//	@Bean
//	public ModelMapper modelMapper()
//	{
//		return new ModelMapper();
//	}

}