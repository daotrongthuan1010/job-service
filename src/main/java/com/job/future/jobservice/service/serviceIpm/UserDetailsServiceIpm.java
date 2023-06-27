package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.model.Users;
import com.job.future.jobservice.model.security.UserRole;
import com.job.future.jobservice.repository.RoleRepository;
import com.job.future.jobservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceIpm implements UserDetailsService {

    private final UserRepository userRepository;

    private RoleRepository roleRepository;

    private static final String USER_NOT_FOUND = "USER_NOT_FOUND";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                mapAuthorities(user.getUserRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        userRoles.forEach(userRole -> authorities.add(new SimpleGrantedAuthority(userRole.getRole().getName())));
        return authorities;
    }
    }

