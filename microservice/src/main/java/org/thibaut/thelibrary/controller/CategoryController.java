package org.thibaut.thelibrary.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.thibaut.thelibrary.dto.CategoryDTO;
import org.thibaut.thelibrary.exception.ResourceNotFoundException;
import org.thibaut.thelibrary.service.contract.CategoryService;
import org.thibaut.thelibrary.utils.RestPreconditions;
import org.thibaut.thelibrary.utils.SingleResourceRetrievedEvent;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin("*")
public class CategoryController {

	private CategoryService categoryService;
	private ApplicationEventPublisher eventPublisher;


	@GetMapping("/category/{id}")
	public CategoryDTO findById( @PathVariable("id") @NonNull Long id){
		try {
			CategoryDTO categoryDTO = RestPreconditions.checkFound( categoryService.findById( id ) );
//			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return categoryDTO;
		}
		catch ( NullPointerException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "The book ID to find is null", ex );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Category not found", ex );
		}
	}


	@GetMapping("/categories")
	public List<CategoryDTO> findAll(HttpServletResponse response){
		try {
			List<CategoryDTO> categoryDTOList = RestPreconditions.checkFound( categoryService.findAll( ) );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return categoryDTOList;
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "No editor found", ex );
		}
	}


	@PostMapping("/category")
	public CategoryDTO save( @RequestBody CategoryDTO categoryDTO, HttpServletResponse response ){
		try {
			RestPreconditions.checkFound( categoryDTO );
			CategoryDTO categoryDTOToSave	= categoryService.save( categoryDTO );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return categoryDTOToSave;
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "The editor to save is null", ex );
		}
	}


	@DeleteMapping("/category")
	public void delete( @PathVariable("id") Long id, HttpServletResponse response ){
		try {
			RestPreconditions.checkNull(  id );
			categoryService.deleteById( id );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
		}
		catch ( NullPointerException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Category ID to delete is null", ex );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Category to delete cannot be found", ex );
		}
	}


	@DeleteMapping("/categories")
	public void deleteList( @RequestBody() List<Long> idList, HttpServletResponse response ){
		try {
			RestPreconditions.checkFound( idList );
			categoryService.deleteList( idList );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Category list to delete is null", ex );
		}
	}
}
