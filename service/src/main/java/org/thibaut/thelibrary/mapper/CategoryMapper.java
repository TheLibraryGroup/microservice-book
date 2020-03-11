package org.thibaut.thelibrary.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.CategoryDTO;
import org.thibaut.thelibrary.entity.CategoryEntity;

import java.util.List;


@Mapper(uses = BookMapper.class)
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );


	@Named( "NoCategory" )
	@Mapping(target = "bookList", qualifiedByName = "NoCategory")
	CategoryDTO toDTO( CategoryEntity categoryEntity );

//	@Named( "NoBook" )
//	@Mapping(target = "bookList", ignore = true)
//	CategoryDTO toDTONoBook( CategoryEntity categoryEntity );


	@Named( "NoCategory" )
	@IterableMapping(qualifiedByName="NoCategory")
	List<CategoryDTO> toDTOList( List< CategoryEntity > categoryEntityList );

//	@Named( "NoBook" )
//	@IterableMapping(qualifiedByName="NoBook")
//	List<CategoryDTO> toDTOListNoBook( List< CategoryEntity > categoryEntityList );


	CategoryEntity toEntity( CategoryDTO categoryDTO );

	List<CategoryEntity> toEntityList( List< CategoryDTO > categoryDTOList );

}
