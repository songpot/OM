package net.tot3g.omclient.service.impl;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.tot3g.omclient.webapp.util.CustomUsernamePasswordAuthenticationFilter;


public class CRMUserDetailsService implements UserDetailsService {
	
	private static final GrantedAuthority ROLE_USER = new GrantedAuthority() {
		
		/**
         * 
         */
        private static final long serialVersionUID = 1L;

		public String getAuthority() {
			if(CustomUsernamePasswordAuthenticationFilter.userlevel.equals("2"))
				return "ROLE_EDITOR";
			else if(CustomUsernamePasswordAuthenticationFilter.userlevel.equals("4"))
				return "ROLE_UPERCALLCENTER";
			else if(CustomUsernamePasswordAuthenticationFilter.userlevel.equals("3"))
				return "ROLE_CALLCENTER";
			else if(CustomUsernamePasswordAuthenticationFilter.userlevel.equals("5"))
				return "ROLE_MANAGER";
			else			
				return "ROLE_USER";
		}
	};

	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException, DataAccessException {
		UserDetails userDetails = new UserDetails() {
			
			/**
             * 
             */
            private static final long serialVersionUID = 1L;

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
				return Arrays.asList(new GrantedAuthority[] {ROLE_USER});
			}
		};
		return userDetails;
	}

}
