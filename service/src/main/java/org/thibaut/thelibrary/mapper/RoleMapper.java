package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.RoleDTO;
import org.thibaut.thelibrary.entity.RoleEntity;

import java.util.List;


@Mapper
public interface RoleMapper {

	RoleMapper INSTANCE = Mappers.getMapper( RoleMapper.class );

	RoleDTO roleToDTO( RoleEntity roleEntity );

	List<RoleDTO> roleToDTOList( List< RoleEntity > roleEntityList );

	RoleEntity roleToEntity( RoleDTO roleDTO );

	List<RoleEntity> roleToEntityList( List< RoleDTO > roleDTOList );

}
