package org.thibaut.thelibrary.mapper;

import org.junit.jupiter.api.Test;
import org.thibaut.thelibrary.dto.EditorDTO;
import org.thibaut.thelibrary.entity.BookEntity;
import org.thibaut.thelibrary.entity.EditorEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EditorMapperTest {

	@Test
	void toDTO( ) {
	}

	@Test
	void toDTOnoEditor( ) {
		BookEntity bookEntity = BookEntity.builder()
				                        .title( "Le cycle de Fondation, I : Fondation" )
				                        .numberOfPages( 416 )
				                        .language( "French")
				                        .isbn( 2070360539L )
										.editor( EditorEntity.builder( )
												         .name( "Folio" )
												         .build( ) )
				                        .build();
		final EditorEntity editorEntity = EditorEntity.builder( )
				                                  .name( "Folio" )
				                                  .bookList( Arrays.asList( bookEntity ) )
				                                  .build( );

		final EditorDTO editorDTO = EditorMapper.INSTANCE.toDTO( editorEntity );

		assertNotNull( editorDTO );
		assertEquals( "Folio", editorDTO.getName() );

	}

	@Test
	void toDTOList( ) {
	}

	@Test
	void toEntity( ) {
	}

	@Test
	void toEntityList( ) {
	}
}
