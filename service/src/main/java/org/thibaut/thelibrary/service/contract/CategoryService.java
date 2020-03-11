package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

	CategoryDTO findById( Long id );

	CategoryDTO findByName( String name );

	List<CategoryDTO> findAll( );

	CategoryDTO save( CategoryDTO categoryDTO );

	void deleteById( Long id );

	void deleteList( List< Long > idList );
}
