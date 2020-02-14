package org.thibaut.thelibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.service.contract.PasswordService;

@Component
public class PasswordServiceImpl implements PasswordService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public String crypt( String password ) {
		return bCryptPasswordEncoder.encode( password );
	}
}
