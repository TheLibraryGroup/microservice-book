package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;

import java.util.List;


@Mapper
public interface BookMapper {

	BookMapper INSTANCE = Mappers.getMapper( BookMapper.class );

	@Mapping( target = "editor.bookList", ignore = true)
	BookDTO toDTO( BookEntity bookEntity );

	@Named( "noEditor" )
	@Mapping(source = "editor", target = "editor", ignore = true)
	BookDTO toDTOWithoutEditor( BookEntity bookEntity );

	List<BookDTO> toDTOList( List<BookEntity> bookEntityList );

	@Mapping( target = "editor.bookList", ignore = true)
	BookEntity toEntity( BookDTO bookDTO );

	List<BookEntity> toEntityList( List<BookDTO> bookDTOList );

}
