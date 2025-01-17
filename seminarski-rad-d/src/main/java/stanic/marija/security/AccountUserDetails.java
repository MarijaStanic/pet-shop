package stanic.marija.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import stanic.marija.model.Role;
import stanic.marija.model.SalesUnit;
import stanic.marija.model.User;

public class AccountUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final User user;
	static final Logger logger = LoggerFactory
			.getLogger(AccountUserDetails.class);

	public AccountUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			authorities
					.add(new SimpleGrantedAuthority("ROLE_" + role.getType()));
		}
		logger.info("authorities : {}", authorities);
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
