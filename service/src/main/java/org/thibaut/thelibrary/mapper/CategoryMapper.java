package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.CategoryDTO;
import org.thibaut.thelibrary.entity.CategoryEntity;

import java.util.List;


@Mapper
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );

	CategoryDTO categoryToDTO( CategoryEntity categoryEntity );

	List<CategoryDTO> categoryToDTOList( List< CategoryEntity > categoryEntityList );

	CategoryEntity categoryToEntity( CategoryDTO categoryDTO );

	List<CategoryEntity> categoryToEntityList( List< CategoryDTO > categoryDTOList );

}
