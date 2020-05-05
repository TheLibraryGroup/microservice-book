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
import org.thibaut.thelibrary.dto.document.BookDocDTO;
import org.thibaut.thelibrary.exception.ResourceNotFoundException;
import org.thibaut.thelibrary.service.contract.BookService;
import org.thibaut.thelibrary.service.impl.BookDocumentServiceImpl;
import org.thibaut.thelibrary.utils.RestPreconditions;
import org.thibaut.thelibrary.utils.SingleResourceRetrievedEvent;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin("*")
public class BookDocController {

	private final BookDocumentServiceImpl bookService;
	private final ApplicationEventPublisher eventPublisher;
	private static final Logger LOGGER = LoggerFactory.getLogger( BookDocController.class);

	@GetMapping("/book/doc/{keywords}")
	@PreAuthorize("permitAll()")
	public List< BookDocDTO > findByTitleAndSummaryAndAuthorAndEditor( @PathVariable("keywords") String keywords, HttpServletResponse response){
		LOGGER.info( "CLASS < BookDocController > - Method < findByTitleAndSummaryAndAuthorAndEditor > - param < " + keywords + " >"  );
		try {
			List<BookDocDTO> bookDocDTOSet =
					RestPreconditions.checkFound( bookService.findByTitleAndSummaryAndAuthorAndEditor( keywords ) );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return bookDocDTOSet;
		}
		catch ( ResourceNotFoundException | IOException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Book not found", ex );
		}
	}

}
