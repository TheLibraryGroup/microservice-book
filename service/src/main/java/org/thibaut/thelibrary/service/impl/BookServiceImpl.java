package org.thibaut.thelibrary.service.impl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;
import org.thibaut.thelibrary.mapper.BookMapper;
import org.thibaut.thelibrary.repository.BookRepository;
import org.thibaut.thelibrary.service.contract.BookService;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	private BookMapper bookMapper;
	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

	@Override
	public BookDTO findById( Long id ){
		LOGGER.info( "CLASS < BookServiceImpl > - Method < findById > - param < " + id + " >"  );
		return bookMapper.toDTO( bookRepository.getOne( id ));
	}


	@Override
	public List< BookEntity > getBookByTitle( String title ){
		return bookRepository.getBooksByTitleContains( title );
	}


	@Override
	public List<BookDTO> findAll( ){
		return bookMapper.toDTOList( bookRepository.findAll());
	}


	@Override
	public BookDTO save( BookDTO bookDTO ){
		bookRepository.save( bookMapper.toEntity( bookDTO ) );
		return bookDTO;
	}


	@Override
	public void deleteById( Long id ){
		bookRepository.deleteById( id );
	}


	@Override
	public void deleteList( List< Long > idList ){
		for ( Long id: idList ) {
			deleteById( id );
		}
	}

}
