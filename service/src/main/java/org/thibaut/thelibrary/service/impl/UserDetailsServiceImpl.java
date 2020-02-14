package org.thibaut.thelibrary.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.dto.UserDTO;
import org.thibaut.thelibrary.mapper.UserMapper;
import org.thibaut.thelibrary.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;


	public UserDetailsServiceImpl( UserRepository userRepository ) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername( String username) throws UsernameNotFoundException {
		UserDTO user = UserMapper.INSTANCE.userToDTO( userRepository.findByUserName(username));
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(user.getUserName(), user.getPassword(), getAuthority());
	}

	public List< SimpleGrantedAuthority > getAuthority( ) {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}
