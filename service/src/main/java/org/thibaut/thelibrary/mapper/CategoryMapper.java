package org.thibaut.thelibrary.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.thibaut.thelibrary.dto.CategoryDTO;
import org.thibaut.thelibrary.entity.CategoryEntity;

import java.util.List;


@Mapper(componentModel = "spring",uses = BookMapper.class)
public interface CategoryMapper {


	@Named( "NoCategory" )
	@Mapping(target = "bookList", qualifiedByName = "NoCategory")
	CategoryDTO toDTO( CategoryEntity categoryEntity );

	@Named( "NoBook" )
	@Mapping(target = "bookList", ignore = true)
	CategoryDTO toDTONoBook( CategoryEntity categoryEntity );


	@Named( "NoCategory" )
	@IterableMapping(qualifiedByName="NoCategory")
	List<CategoryDTO> toDTOList( List< CategoryEntity > categoryEntityList );

	@Named( "NoBook" )
	@IterableMapping(qualifiedByName="NoBook")
	List<CategoryDTO> toDTOListNoBook( List< CategoryEntity > categoryEntityList );


	@Named( "NoCategory" )
	@Mapping(target = "bookList", qualifiedByName = "NoCategory")
	CategoryEntity toEntity( CategoryDTO categoryDTO );

	@Named( "NoBook" )
	@Mapping(target = "bookList", ignore = true)
	CategoryEntity toEntityNoBook( CategoryDTO categoryDTO );


	@Named( "NoCategory" )
	@IterableMapping(qualifiedByName="NoCategory")
	List<CategoryEntity> toEntityList( List< CategoryDTO > categoryDTOList );

	@Named( "NoBook" )
	@IterableMapping(qualifiedByName="NoBook")
	List<CategoryEntity> toEntityListNoBook( List< CategoryDTO > categoryDTOList );

}
