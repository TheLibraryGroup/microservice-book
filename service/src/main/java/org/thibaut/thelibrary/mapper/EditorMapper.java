package org.thibaut.thelibrary.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.thibaut.thelibrary.dto.EditorDTO;
import org.thibaut.thelibrary.entity.EditorEntity;

import java.util.List;


@Mapper(componentModel = "spring", uses = BookMapper.class)
public interface EditorMapper {

	@Named( "NoEditor" )
	@Mapping(target = "bookList", qualifiedByName = "NoEditor")
	EditorDTO toDTO( EditorEntity editorEntity );

	@Named( "NoBook" )
	@Mapping(target = "bookList", ignore = true)
	EditorDTO toDTONoBook( EditorEntity editorEntity );


	@Named( "NoEditor" )
	@IterableMapping(qualifiedByName="NoEditor")
	List< EditorDTO > toDTOList( List< EditorEntity > editorEntityList );

	@Named( "NoBook" )
	@IterableMapping(qualifiedByName="NoBook")
	List< EditorDTO > toDTOListNoBook( List< EditorEntity > editorEntityList );

	@Named( "NoBook" )
	@Mapping(target = "bookList", qualifiedByName = "NoBook")
	EditorEntity toEntity( EditorDTO editorDTO );

	@Named( "NoBook" )
	@IterableMapping(qualifiedByName="NoBook")
	List< EditorEntity > toEntityList( List< EditorDTO > editorDTOList );
}
