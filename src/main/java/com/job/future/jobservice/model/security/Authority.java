package com.job.future.jobservice.model.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")

public class Authority implements GrantedAuthority {

	private final String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}
	
	public String getAuthority() {
		return authority;
	}

}
