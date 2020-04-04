package org.thibaut.thelibrary.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Override
	@HystrixCommand(fallbackMethod = "defaultBook",
			commandProperties = {
					@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
			})
	public BookDTO findById( Long id ){
		return bookMapper.toDTO( bookRepository.getOne( id ));
	}

	public BookDTO defaultBook(@PathVariable("id") @NonNull Long id){
		return BookDTO.builder().title( "DEFAULTBOOK" ).build();
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
