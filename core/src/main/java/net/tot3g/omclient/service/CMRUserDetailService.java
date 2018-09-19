package net.tot3g.omclient.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CMRUserDetailService implements UserDetailsService {

	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException, DataAccessException {
		UserDetails userDetail = new UserDetails() {

			private GrantedAuthority ROLE_USER = new GrantedAuthority() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public String getAuthority() {
					return "ROLE_ADMIN";
				}
			};

			public boolean isEnabled() {
				return true;
			}

			public boolean isCredentialsNonExpired() {
				return true;
			}

			public boolean isAccountNonLocked() {
				return true;
			}

			public boolean isAccountNonExpired() {
				return true;
			}

			public String getUsername() {
				return username;
			}

			public String getPassword() {

				return "";
			}

			public Collection<GrantedAuthority> getAuthorities() {
				return Arrays.asList(new GrantedAuthority[] { ROLE_USER });
			}
		};
		return userDetail;
	}

}
