package org.thibaut.thelibrary.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.thibaut.thelibrary.dto.EditorDTO;
import org.thibaut.thelibrary.exception.ResourceNotFoundException;
import org.thibaut.thelibrary.service.contract.EditorService;
import org.thibaut.thelibrary.utils.RestPreconditions;
import org.thibaut.thelibrary.utils.SingleResourceRetrievedEvent;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin("*")
public class EditorController {

	private EditorService editorService;
	private ApplicationEventPublisher eventPublisher;


	@GetMapping("/editor/{id}")
	public EditorDTO findById( @PathVariable("id") @NonNull Long id){
		try {
			EditorDTO editorDTO = RestPreconditions.checkFound( editorService.findById( id ) );
//			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return editorDTO;
		}
		catch ( NullPointerException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "The book ID to find is null", ex );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Editor not found", ex );
		}
	}


	@GetMapping("/editors")
	public List<EditorDTO> findAll(HttpServletResponse response){
		try {
			List<EditorDTO> editorDTOList = RestPreconditions.checkFound( editorService.findAll( ) );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return editorDTOList;
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "No editor found", ex );
		}
	}


	@PostMapping("/editor")
	public EditorDTO save( @RequestBody EditorDTO editorDTO, HttpServletResponse response ){
		try {
			RestPreconditions.checkFound( editorDTO );
			EditorDTO editorDTOToSave	= editorService.save( editorDTO );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return editorDTOToSave;
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "The editor to save is null", ex );
		}
	}


	@DeleteMapping("/editor")
	public void delete( @PathVariable("id") Long id, HttpServletResponse response ){
		try {
			RestPreconditions.checkNull(  id );
			editorService.deleteById( id );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
		}
		catch ( NullPointerException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "editor ID to delete is null", ex );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "editor to delete cannot be found", ex );
		}
	}


	@DeleteMapping("/editors")
	public void deleteList( @RequestBody() List<Long> idList, HttpServletResponse response ){
		try {
			RestPreconditions.checkFound( idList );
			editorService.deleteList( idList );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
		}
		catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Editor list to delete is null", ex );
		}
	}
}
