package org.thibaut.thelibrary.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;

import java.util.List;

@Mapper/*(uses = CategoryMapper.class)*/
public interface BookMapper {

	BookMapper INSTANCE = Mappers.getMapper( BookMapper.class );


//	@Named( "NoBook" )
//	@Mapping(target = "categoryList", qualifiedByName = "NoBook")
	@Mapping( target = "editor.bookList", ignore = true)
	BookDTO toDTO( BookEntity bookEntity );

	@Named( "NoEditor" )
	@Mapping(target = "editor", ignore = true)
	BookDTO toDTONoEditor( BookEntity bookEntity );

	@Named( "NoCategory" )
	@Mapping(target = "categoryList", ignore = true)
	BookDTO toDTONoCategory( BookEntity bookEntity );


//	@Named( "NoBook" )
//	@IterableMapping(qualifiedByName="NoBook")
	List<BookDTO> toDTOList( List<BookEntity> bookEntityList );

	@Named( "NoCategory" )
	@IterableMapping(qualifiedByName="NoCategory")
	List<BookDTO> toDTOListNoCategory( List<BookEntity> bookEntityList );

	@Named( "NoEditor" )
	@IterableMapping(qualifiedByName="NoEditor")
	List<BookDTO> toDTOListNoEditor( List<BookEntity> bookEntityList );


	@Mapping( target = "editor.bookList", ignore = true)
	BookEntity toEntity( BookDTO bookDTO );

	List<BookEntity> toEntityList( List<BookDTO> bookDTOList );

}
