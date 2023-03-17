package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.model.User;
import com.job.future.jobservice.repository.UserRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceIpm implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String githubId) throws UsernameNotFoundException {
    User user = userRepository.findByAuthenId(githubId)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with github id: " + githubId));

    return new org.springframework.security.core.userdetails.User(
        user.getName(),
        user.getAccessToken(),
        new ArrayList<>());
  }

}
