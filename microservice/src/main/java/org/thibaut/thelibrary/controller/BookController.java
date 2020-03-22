package org.thibaut.thelibrary.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin(origins = "*")
public class BookController {

	private BookService bookService;
	private ApplicationEventPublisher eventPublisher;


	@GetMapping("/book/{id}")
	public BookDTO findById( @PathVariable("id") @NonNull Long id){
		try {
			BookDTO bookDTO = RestPreconditions.checkFound( bookService.findById( id ) );
//			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return bookDTO;
		}
		catch ( NullPointerException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "The book ID to find is null", ex );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Book not found", ex );
		}
	}


	@GetMapping("/books")
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
