package com.example.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
//@EnableJpaAuditing
@EnableAspectJAutoProxy
public class SpringboottestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottestingApplication.class, args);
	}
	@Bean
	public AuditorAware<String> createAuditorProvider() {
		//first Way
		//		String name="Naveen";
		//		Optional<String> nameO=Optional.of(name);
		//	    return () -> nameO;
		//second Way
		return () -> Optional.of("Naveen");
		// should be from context/session
		// Can use Spring Security to return currently logged in user
		// return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
	}
}
