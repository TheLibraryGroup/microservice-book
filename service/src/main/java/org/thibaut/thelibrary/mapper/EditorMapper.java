package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.EditorDTO;
import org.thibaut.thelibrary.entity.EditorEntity;

import java.util.List;


@Mapper
public interface EditorMapper {

	EditorMapper INSTANCE = Mappers.getMapper( EditorMapper.class );


	EditorDTO toDTO( EditorEntity editorEntity );

//	@InheritInverseConfiguration
	@Named( "noEditor" )
	@Mapping(source = "bookList", target = "bookList", qualifiedByName = "noEditor")
	EditorDTO toDTOnoEditor( EditorEntity editorEntity );

	List<EditorDTO> toDTOList( List< EditorEntity > editorEntityList );

	EditorEntity toEntity( EditorDTO editorDTO );

	List<EditorEntity> toEntityList( List< EditorDTO > editorDTOList );

}
