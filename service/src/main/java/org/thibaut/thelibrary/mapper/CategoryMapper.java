package org.thibaut.thelibrary.mapper;

import org.mapstruct.*;
import org.thibaut.thelibrary.dto.CategoryDTO;
import org.thibaut.thelibrary.dto.CycleAvoidingMappingContext;
import org.thibaut.thelibrary.entity.CategoryEntity;

import java.util.List;


@Mapper(componentModel = "spring",uses = BookMapper.class)
public interface CategoryMapper {


	@Named( "NoCategory" )
	@Mapping(target = "bookList", qualifiedByName = "NoCategory")
	CategoryDTO toDTO( CategoryEntity categoryEntity , @Context CycleAvoidingMappingContext context);

	@Named( "NoBook" )
	@Mapping(target = "bookList", ignore = true)
	CategoryDTO toDTONoBook( CategoryEntity categoryEntity , @Context CycleAvoidingMappingContext context);


	@Named( "NoCategory" )
	@IterableMapping(qualifiedByName="NoCategory")
	List<CategoryDTO> toDTOList( List< CategoryEntity > categoryEntityList , @Context CycleAvoidingMappingContext context);

	@Named( "NoBook" )
	@IterableMapping(qualifiedByName="NoBook")
	List<CategoryDTO> toDTOListNoBook( List< CategoryEntity > categoryEntityList , @Context CycleAvoidingMappingContext context);


	CategoryEntity toEntity( CategoryDTO categoryDTO , @Context CycleAvoidingMappingContext context);

	List<CategoryEntity> toEntityList( List< CategoryDTO > categoryDTOList , @Context CycleAvoidingMappingContext context);

}
