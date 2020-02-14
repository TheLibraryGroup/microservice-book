package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;

import java.util.List;

public interface BookService {

	BookDTO getBookById( Long id );

	List< BookEntity > getBookByTitle( String title );

	List<BookDTO> getBookDTOList( );

	BookDTO save( BookDTO bookDTO );

	void delete( Long id );

	void deleteList( List< Long > idList );
}
