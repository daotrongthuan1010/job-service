package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.dto.UserDTO;
import com.job.future.jobservice.model.User;
import com.job.future.jobservice.model.security.Role;
import com.job.future.jobservice.model.security.UserRole;
import com.job.future.jobservice.repository.RoleRepository;
import com.job.future.jobservice.repository.UserRepository;
import com.job.future.jobservice.service.UserService;
import com.job.future.jobservice.utils.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;


	@Override
	public Optional<User> findById(Long id) {
		Optional<User> opt = userRepository.findById(id);
		return opt;
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
	}
	

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Not found"));
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	@Transactional
	public User createUser(String username, String password, String email, List<String> roles) {
		User user = findByUsername(username);
		if (user != null) {
			return user;
		} else {
			user = new User();
			user.setUsername(username);
			user.setPassword(SecurityUtility.passwordEncoder().encode(password));
			user.setEmail(email);			
			Set<UserRole> userRoles = new HashSet<>();
			for (String rolename : roles) {
				Role role = roleRepository.findByName(rolename);
				if (role == null) {
					role = new Role();
					role.setName(rolename);
					roleRepository.save(role);
				}
				userRoles.add(new UserRole(user, role));
			}

			user.setUserRoles(userRoles);
			return userRepository.save(user);
		}
	}

	@Override
	public List<UserDTO> findAllUser(String name) {
		List<UserDTO> list = new ArrayList<>();
		List<Map<String, Object>> obj = userRepository.findAllUserByHoTenorEmail(name);
		obj.forEach(x ->
		{
			UserDTO userDTO = new UserDTO();
			userDTO.setId(String.valueOf(x.get("id")));
			userDTO.setEmail(String.valueOf(x.get("email")));
			userDTO.setHoTen(String.valueOf(x.get("ho_ten")));


			list.add(userDTO);

		});

		return list;
	}

}
