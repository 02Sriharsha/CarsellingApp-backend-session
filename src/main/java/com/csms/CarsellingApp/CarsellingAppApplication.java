package com.csms.CarsellingApp;

import com.csms.CarsellingApp.entity.Role;
import com.csms.CarsellingApp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CarsellingAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarsellingAppApplication.class, args);
	}

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		Role role1 = new Role();
		role1.setId(601);
		role1.setName("seller");
		
		Role role2 = new Role();
		role2.setId(600);
		role2.setName("buyer");

		roleRepository.saveAll(List.of(role1 , role2));
//		roleRepository.save(role1);
//		roleRepository.save(role2);
	}
}
