package com.job.future.jobservice.config.oauthen2;

import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public class CustomOAuth2User implements OAuth2User {

  @Autowired
  private OAuth2User oAuth2User;

  public CustomOAuth2User(OAuth2User user) {
  }

  @Override
  public <A> A getAttribute(String name) {
    return OAuth2User.super.getAttribute(name);
  }

  @Override
  public Map<String, Object> getAttributes() {
    return oAuth2User.getAttributes();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return oAuth2User.getAuthorities();
  }

  @Override
  public String getName() {
    return oAuth2User.getAttribute("name");
  }
}
