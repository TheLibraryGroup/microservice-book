package org.thibaut.thelibrary.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.dto.CycleAvoidingMappingContext;
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

	@Override
	public BookDTO findById( Long id ){
		return bookMapper.toDTO( bookRepository.getOne( id ), new CycleAvoidingMappingContext());
	}


	@Override
	public List< BookEntity > getBookByTitle( String title ){
		return bookRepository.getBooksByTitleContains( title );
	}


	@Override
	public List<BookDTO> findAll( ){
		return bookMapper.toDTOList( bookRepository.findAll(), new CycleAvoidingMappingContext());
	}


	@Override
	public BookDTO save( BookDTO bookDTO ){
		bookRepository.save( bookMapper.toEntity( bookDTO, new CycleAvoidingMappingContext() ) );
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
