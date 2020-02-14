package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.LibraryDTO;
import org.thibaut.thelibrary.entity.LibraryEntity;

import java.util.List;


@Mapper
public interface LibraryMapper {

	LibraryMapper INSTANCE = Mappers.getMapper( LibraryMapper.class );

	LibraryDTO libraryToDTO( LibraryEntity libraryEntity );

	List<LibraryDTO> libraryToDTOList( List< LibraryEntity > libraryEntityList );

	LibraryEntity libraryToEntity( LibraryDTO libraryDTO );

	List<LibraryEntity> libraryToEntityList( List< LibraryDTO > libraryDTOList );

}
