package org.thibaut.thelibrary.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.EditorDTO;
import org.thibaut.thelibrary.entity.EditorEntity;

import java.util.List;


@Mapper(uses = BookMapper.class)
public interface EditorMapper {

	EditorMapper INSTANCE = Mappers.getMapper( EditorMapper.class );

	@Named( "NoEditor" )
	@Mapping(target = "bookList", qualifiedByName = "NoEditor")
	EditorDTO toDTO( EditorEntity editorEntity );

	@Named( "NoCategory" )
	@Mapping(target = "bookList", ignore = true)
	EditorDTO toDTONoBook( EditorEntity editorEntity );


	@Named( "NoEditor" )
	@IterableMapping(qualifiedByName="NoEditor")
	List<EditorDTO> toDTOList( List< EditorEntity > editorEntityList );

	@Named( "NoCategory" )
	@IterableMapping(qualifiedByName="NoCategory")
	List<EditorDTO> toDTOListNoCategory( List< EditorEntity > editorEntityList );


	EditorEntity toEntity( EditorDTO editorDTO );

	List<EditorEntity> toEntityList( List< EditorDTO > editorDTOList );

}
