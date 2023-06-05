package com.job.future.jobservice;

import com.job.future.jobservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@AllArgsConstructor
public class StoreAppStartupRunner implements CommandLineRunner{


	private final UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		userService.createUser("admin", "admin", "admin@admin.com", Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
	}
}

