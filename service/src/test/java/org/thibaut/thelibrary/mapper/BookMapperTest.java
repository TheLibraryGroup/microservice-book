package org.thibaut.thelibrary.mapper;

import org.junit.jupiter.api.Test;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;
import org.thibaut.thelibrary.entity.EditorEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookMapperTest {

	@Test
	void toDTO( ) {

		final EditorEntity editorEntity = EditorEntity.builder( ).name( "Folio" ).build( );
		BookEntity bookEntity = BookEntity.builder()
				                  .title( "Le cycle de Fondation, I : Fondation" )
				                  .numberOfPages( 416 )
				                  .language( "French")
				                  .isbn( 2070360539L )
				                  .editor( editorEntity )
				                  .build();

		final BookDTO bookDTO = BookMapper.INSTANCE.toDTO( bookEntity/*, new CycleAvoidingMappingContext( )*/ );

		assertNotNull( bookDTO );
		assertEquals( bookEntity.getTitle(), bookDTO.getTitle()  );
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
