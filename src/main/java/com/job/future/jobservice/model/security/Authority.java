package com.job.future.jobservice.model.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
@Getter
public class Authority implements GrantedAuthority {

	private final String authority;

	public Authority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}
	


}
