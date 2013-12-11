package ua.softserve.clientbanking.domain;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class Role implements GrantedAuthority {
	String role;
	
	public Role(String role) {
		this.role=role;
	}
	
	@Override
	public String getAuthority() {
		return role;
	}

}
