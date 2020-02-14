package org.thibaut.thelibrary.service.impl;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;
import org.thibaut.thelibrary.entity.Languages;
import org.thibaut.thelibrary.repository.BookRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
@DisplayName( "Testing BookService" )
class BookServiceImplTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookServiceImpl bookService;

	@BeforeEach
	void setUp( ) {
		MockitoAnnotations.initMocks( this );
	}

	@Test
	void getBookById( ) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		BookEntity mockedBook = BookEntity.builder()
				.id( 1L )
				.title( "Fondation" )
				.numberOfPages( 416 )
				.language( Languages.FR.toString() )
				.publicationDate( formatter.parseDateTime("01/01/1951") )
				.isbn( 9788804119135L )
				.build();

		when(bookRepository.findById( anyLong() )).thenReturn( Optional.ofNullable( mockedBook ) );

		final BookDTO bookDTO = bookService.getBookById( 5L );

		Assertions.assertNotNull( bookDTO );
		Assertions.assertEquals( "Fondation", bookDTO.getTitle() );

	}

	@Test
	void getBookByTitle( ) {
	}

	@Test
	void getBookDTOList( ) {
	}

	@Test
	void save( ) {
	}

	@Test
	void delete( ) {
	}

	@Test
	void deleteList( ) {
	}
}
