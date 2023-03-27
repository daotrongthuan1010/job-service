package com.job.future.jobservice.utils;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public class ConstantSecurity {
  public static final String SECRET = "oursecretkey";
  public static final long EXPIRATION_TIME = 864_000_000; // 10 days
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String SIGN_UP_URL = "/api/user/create";
}
