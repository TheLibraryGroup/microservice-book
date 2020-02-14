package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.AuthorDTO;
import org.thibaut.thelibrary.entity.AuthorEntity;

import java.util.List;


@Mapper
public interface AuthorMapper {

	AuthorMapper INSTANCE = Mappers.getMapper( AuthorMapper.class );

	AuthorDTO authorToDTO( AuthorEntity authorEntity );

	List<AuthorDTO> authorToDTOList( List< AuthorEntity > authorEntityList );

	AuthorEntity bookToEntity( AuthorDTO authorDTO );

	List<AuthorEntity> authorToEntityList( List< AuthorDTO > authorDTOList );

}
