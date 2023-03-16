package com.job.future.jobservice.service;

import com.job.future.jobservice.model.User;
import com.job.future.jobservice.repository.UserRepository;
import com.job.future.jobservice.service.serviceIpm.UserDetailsServiceIpm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Service
@RequiredArgsConstructor
public class GithubOAuth2UserService extends DefaultOAuth2UserService {


  private final UserRepository userRepository;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2User oAuth2User = super.loadUser(userRequest);

    String githubId = oAuth2User.getAttribute("id");
    String name = oAuth2User.getAttribute("name");
    String email = oAuth2User.getAttribute("email");
    String accessToken = userRequest.getAccessToken().getTokenValue();

    User user = userRepository.findByAuthenId(githubId)
        .orElseGet(User::new);

    assert githubId != null;
    User.builder()
        .id(Long.valueOf(githubId))
        .name(name)
        .email(email)
        .authen_id(githubId)
        .accessToken(accessToken);
    userRepository.save(user);

    return oAuth2User;
  }
}
