package org.thibaut.thelibrary.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.exception.ResourceNotFoundException;
import org.thibaut.thelibrary.service.contract.BookService;
import org.thibaut.thelibrary.utils.RestPreconditions;
import org.thibaut.thelibrary.utils.SingleResourceRetrievedEvent;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin("*")
public class BookController {

	private BookService bookService;
	private ApplicationEventPublisher eventPublisher;
	private static final Logger LOGGER = LoggerFactory.getLogger( BookController.class);


	@GetMapping("/book/{id}")
	@PreAuthorize("permitAll()")
	@HystrixCommand(fallbackMethod = "defaultBook",
			commandProperties = {
					@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
			})
	public BookDTO findById( @PathVariable("id") @NonNull Long id, HttpServletResponse response){
		LOGGER.info( "CLASS < BookController > - Method < findById > - param < " + id + " >"  );
		try {
			BookDTO bookDTO = RestPreconditions.checkFound( bookService.findById( id ) );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return bookDTO;
		}
		catch ( NullPointerException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "The book ID to find is null", ex );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Book not found", ex );
		}
	}

	public BookDTO defaultBook(@PathVariable("id") @NonNull Long id, HttpServletResponse response){
		return BookDTO.builder().title( "DEFAULTBOOK" ).build();
	}


	@GetMapping("/books")
	@PreAuthorize("hasAnyRole('admin', 'user')")
	public List<BookDTO> findAll(HttpServletResponse response){
		try {
			List<BookDTO> bookDTOList = RestPreconditions.checkFound( bookService.findAll( ) );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return bookDTOList;
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "No book found", ex );
		}
	}


	@PostMapping("/book")
	@PreAuthorize("hasAnyRole('admin')")
	public BookDTO save( @RequestBody BookDTO bookDTO, HttpServletResponse response ){
		try {
			RestPreconditions.checkFound( bookDTO );
			BookDTO bookDTOToSave	= bookService.save( bookDTO );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return bookDTOToSave;
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "The book to save is null", ex );
		}
	}


	@DeleteMapping("/book")
	@PreAuthorize("hasAnyRole('admin')")
	public void delete( @PathVariable("id") Long id, HttpServletResponse response ){
		try {
			RestPreconditions.checkNull(  id );
			bookService.deleteById( id );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
		}
		catch ( NullPointerException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "The book ID to delete is null", ex );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "The book to delete cannot be found", ex );
		}
	}


	@DeleteMapping("/books")
	@PreAuthorize("hasAnyRole('admin')")
	public void deleteList( @RequestBody() List<Long> idList, HttpServletResponse response ){
		try {
			RestPreconditions.checkFound( idList );
			bookService.deleteList( idList );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Book list to delete is null", ex );
		}
	}
}
