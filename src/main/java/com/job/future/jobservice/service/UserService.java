package com.job.future.jobservice.service;




import com.job.future.jobservice.dto.UserDTO;
import com.job.future.jobservice.model.Users;


import java.util.List;
import java.util.Optional;


public interface UserService {
	
	Optional<Users> findById(Long id);
	
	Users findByUsername(String username);
		
	Users findByEmail(String email);
		
	void save(Users user);
	
	Users createUser(String username, String email,  String password, List<String> roles);


}
