package org.thibaut.thelibrary.service.impl;

import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.entity.BookEntity;
import org.thibaut.thelibrary.mapper.BookMapper;
import org.thibaut.thelibrary.repository.BookRepository;
import org.thibaut.thelibrary.service.contract.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;

	public BookServiceImpl( BookRepository bookRepository ) {
		this.bookRepository = bookRepository;
	}

	@Override
	public BookDTO getBookById( Long id ){
		return BookMapper.INSTANCE.toDTO( bookRepository.findById( id ).orElse( null ));
	}

	@Override
	public List< BookEntity > getBookByTitle( String title ){
		return bookRepository.getBooksByTitleContains( title );
	}


	@Override
	public List<BookDTO> getBookDTOList( ){
		return BookMapper.INSTANCE.toDTOList( bookRepository.findAll());
	}

	@Override
	public BookDTO save( BookDTO bookDTO ){
		Optional.of( BookMapper.INSTANCE.toEntity( bookDTO ) ).ifPresent( bookEntity -> bookRepository.save( bookEntity ) );
		bookRepository.save( BookMapper.INSTANCE.toEntity( bookDTO ) );
		return bookDTO;
	}

	@Override
	public void delete( Long id ){
		bookRepository.findById( id ).ifPresent( bookRepository::delete );
	}

	@Override
	public void deleteList( List< Long > idList ){
		Optional.of( bookRepository.findAllById( idList )).ifPresent( bookRepository::deleteAll );
	}

}
