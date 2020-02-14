package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.UserDTO;
import org.thibaut.thelibrary.entity.UserEntity;

import java.util.List;


@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

	UserDTO userToDTO( UserEntity userEntity );

	List<UserDTO> userToDTOList( List< UserEntity > userEntityList );

	UserEntity userToEntity( UserDTO userDTO );

	List<UserEntity> userToEntityList( List< UserDTO > userDTOList );

}
