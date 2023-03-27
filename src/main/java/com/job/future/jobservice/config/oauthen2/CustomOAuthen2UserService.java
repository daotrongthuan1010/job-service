//package com.job.future.jobservice.config.oauthen2;
//
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
///**
// * @author thuandao1010
// * @version 1.0
// * @since 2023-02-11
// */
//@Service
//public class CustomOAuthen2UserService extends DefaultOAuth2UserService {
//
//  @Override
//  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//    return new CustomOAuth2User(super.loadUser(userRequest));
//  }
//
//}