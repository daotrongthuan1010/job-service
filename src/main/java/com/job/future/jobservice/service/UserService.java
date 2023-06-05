package com.job.future.jobservice.service;




import com.job.future.jobservice.dto.UserDTO;
import com.job.future.jobservice.model.User;


import java.util.List;
import java.util.Optional;


public interface UserService {
	
	Optional<User> findById(Long id);
	
	User findByUsername(String username);
		
	User findByEmail(String email);
		
	void save(User user);
	
	User createUser(String username, String email,  String password, List<String> roles);
	List<UserDTO>  findAllUser(String username);

}
