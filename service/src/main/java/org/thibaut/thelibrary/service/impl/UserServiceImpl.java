package org.thibaut.thelibrary.service.impl;

import org.joda.time.DateTime;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.dto.UserDTO;
import org.thibaut.thelibrary.entity.UserEntity;
import org.thibaut.thelibrary.mapper.UserMapper;
import org.thibaut.thelibrary.repository.RoleRepository;
import org.thibaut.thelibrary.repository.UserRepository;
import org.thibaut.thelibrary.service.contract.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	public UserServiceImpl( RoleRepository roleRepository,
	                        UserRepository userRepository,
	                        BCryptPasswordEncoder bCryptPasswordEncoder ) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}


	@Override
	public List<UserDTO> findAll( ) {
		return Optional.of( UserMapper.INSTANCE.userToDTOList( userRepository.findAll() )).orElseThrow( ResourceNotFoundException::new );
	}

	@Override
	public void delete( Long id ) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDTO findOne( String username ) {
		return UserMapper.INSTANCE.userToDTO( userRepository.findByUserName(username));
	}

	@Override
	public UserDTO findById( Long id ) {
		return Optional.of( UserMapper.INSTANCE.userToDTO( userRepository.getOne( id ) ) ).orElseThrow( ResourceNotFoundException::new );
	}

	@Override
	public UserDTO update( UserDTO userDto ) {

		final Optional< UserDTO > optionalUserDTO = Optional.of( userDto );
		optionalUserDTO.ifPresent( userDTO -> userRepository.save( UserMapper.INSTANCE.userToEntity( userDTO ) ) );
		return optionalUserDTO.orElseThrow( ResourceNotFoundException::new );
	}


	@Override
	public UserDTO save( UserDTO user ) {
		final Optional< UserDTO > optionalUserDTO = Optional.of( user );
		optionalUserDTO.ifPresent( userDTO -> UserEntity.builder()
			                                        .userName( user.getUserName() )
													.firstName( user.getFirstName() )
													.lastName( user.getLastName() )
													.registrationDate( DateTime.now() )
													.password( bCryptPasswordEncoder.encode(user.getPassword()) )
												.build());
		return optionalUserDTO.orElseThrow( ResourceNotFoundException::new );
	}

	
	@Override
	public UserEntity findByUserName( String username ) {
		UserEntity userEntity = userRepository.findByUserName( username );
		userEntity.setRoleList( roleRepository.getRolesByUsername( username ) );

		return userEntity;
	}


	@Override
	public UserEntity findByEmail( String email ) {
		UserEntity userEntity = userRepository.findByEmail( email );
		userEntity.setRoleList( roleRepository.getRolesByEmail( email ) );

		return userEntity;
	}
}
