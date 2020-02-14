package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.EditorDTO;
import org.thibaut.thelibrary.entity.EditorEntity;

import java.util.List;


@Mapper
public interface EditorMapper {

	EditorMapper INSTANCE = Mappers.getMapper( EditorMapper.class );

	EditorDTO editorToDTO( EditorEntity editorEntity );

	List<EditorDTO> editorToDTOList( List< EditorEntity > editorEntityList );

	EditorEntity editorToEntity( EditorDTO editorDTO );

	List<EditorEntity> editorToEntityList( List< EditorDTO > editorDTOList );

}
