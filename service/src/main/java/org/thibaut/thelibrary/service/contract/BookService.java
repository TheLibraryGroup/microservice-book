package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;

import java.util.List;

public interface BookService {

	BookDTO findById( Long id );

	List< BookEntity > getBookByTitle( String title );

	List<BookDTO> findAll( );

	BookDTO save( BookDTO bookDTO );

	void deleteById( Long id );

	void deleteList( List< Long > idList );
}
