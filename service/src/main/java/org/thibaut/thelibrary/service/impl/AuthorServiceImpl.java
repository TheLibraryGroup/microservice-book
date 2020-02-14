package org.thibaut.thelibrary.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.entity.AuthorEntity;
import org.thibaut.thelibrary.repository.AuthorRepository;
import org.thibaut.thelibrary.service.contract.AuthorService;

import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService {

	private AuthorRepository authorRepository;

	public AuthorServiceImpl( AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public List< AuthorEntity > getAuthorByLastNameAndFirstName( String lastName, String firstName ){

		return authorRepository.getAuthorsByFirstNameAndLastName( firstName, lastName );
	}


	public AuthorEntity findAuthorByFirstNameAndLastName( Pageable pageable, String firstName, String lastName ){

		/*int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		QAuthor qAuthor = QAuthor.author;

		BooleanBuilder booleanBuilder = new BooleanBuilder();

		if( ! firstName.equals( "" )){
			booleanBuilder
					.and( qAuthor.firstName.containsIgnoreCase( firstName ) )
					.or( qAuthor.lastName.containsIgnoreCase( firstName) );
		}
		if( ! lastName.equals( "" )){
			booleanBuilder
					.and( qAuthor.firstName.containsIgnoreCase( lastName ) )
					.or( qAuthor.lastName.containsIgnoreCase( lastName) );
		}*/
		return null;
	}
}
