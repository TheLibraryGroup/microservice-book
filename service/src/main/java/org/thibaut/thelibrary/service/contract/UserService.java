package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.dto.UserDTO;
import org.thibaut.thelibrary.entity.UserEntity;

import java.util.List;

public interface UserService {


	List< UserDTO > findAll( );

	void delete( Long id );

	UserDTO findOne( String username );

	UserDTO findById( Long id );

	UserDTO update( UserDTO userDto );

	UserDTO save( UserDTO user );

	UserEntity findByUserName( String username );

	UserEntity findByEmail( String email );
}
