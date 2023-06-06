package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.dto.UserDTO;
import com.job.future.jobservice.model.Users;
import com.job.future.jobservice.model.security.Role;
import com.job.future.jobservice.model.security.UserRole;
import com.job.future.jobservice.repository.RoleRepository;
import com.job.future.jobservice.repository.UserRepository;
import com.job.future.jobservice.service.UserService;
import com.job.future.jobservice.utils.SecurityUtility;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final RoleRepository roleRepository;

	@Override
	public Optional<Users> findById(Long id) {
		Optional<Users> opt = userRepository.findById(id);
		return opt;
	}
	
	@Override
	public Users findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	

	@Override
	public Users findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Not found"));
	}

	@Override
	public void save(Users user) {
		userRepository.save(user);
	}

	@Override
	@Transactional
	public Users createUser(String username, String password, String email, List<String> roles) {
		Users users = findByUsername(username);
		if (users != null) {
			return users;
		} else {
			users = new Users();
			users.setUsername(username);
			users.setPassword(SecurityUtility.passwordEncoder().encode(password));
			users.setEmail(email);
			Set<UserRole> userRoles = new HashSet<>();
			for (String rolename : roles) {
				Role role = roleRepository.findByName(rolename);
				if (role == null) {
					role = new Role();
					role.setName(rolename);
					roleRepository.save(role);
				}
				userRoles.add(new UserRole(users, role));
			}

			users.setUserRoles(userRoles);
			return userRepository.save(users);
		}
	}



}
