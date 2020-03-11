package org.thibaut.thelibrary.mapper;

import org.mapstruct.*;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.dto.CycleAvoidingMappingContext;
import org.thibaut.thelibrary.entity.BookEntity;

import java.util.List;

//@Mapper
@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface BookMapper {


	@Named( "NoBook" )
	@Mappings( {
			@Mapping(target = "categoryList", qualifiedByName = "NoBook"),
			@Mapping( target = "editor.bookList", ignore = true)
	} )
	BookDTO toDTO( BookEntity bookEntity, @Context CycleAvoidingMappingContext context );

	@Named( "NoEditor" )
	@Mapping(target = "editor", ignore = true)
	BookDTO toDTONoEditor( BookEntity bookEntity, @Context CycleAvoidingMappingContext context );

	@Named( "NoCategory" )
	@Mapping(target = "categoryList", ignore = true)
	BookDTO toDTONoCategory( BookEntity bookEntity, @Context CycleAvoidingMappingContext context );


	@Named( "NoBook" )
	@IterableMapping(qualifiedByName="NoBook")
	List<BookDTO> toDTOList( List<BookEntity> bookEntityList, @Context CycleAvoidingMappingContext context );

	@Named( "NoCategory" )
	@IterableMapping(qualifiedByName="NoCategory")
	List<BookDTO> toDTOListNoCategory( List<BookEntity> bookEntityList, @Context CycleAvoidingMappingContext context );

	@Named( "NoEditor" )
	@IterableMapping(qualifiedByName="NoEditor")
	List<BookDTO> toDTOListNoEditor( List<BookEntity> bookEntityList, @Context CycleAvoidingMappingContext context );


//	@Mapping( target = "editor.bookList", ignore = true)
	BookEntity toEntity( BookDTO bookDTO, @Context CycleAvoidingMappingContext context );

	List<BookEntity> toEntityList( List<BookDTO> bookDTOList, @Context CycleAvoidingMappingContext context );

}
