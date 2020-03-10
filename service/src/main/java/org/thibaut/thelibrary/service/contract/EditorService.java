package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.dto.EditorDTO;

import java.util.List;

public interface EditorService {
	EditorDTO findById( Long id );

	List< EditorDTO > findByName( String name );

	List<EditorDTO> findAll( );

	EditorDTO save( EditorDTO bookDTO );

	void deleteById( Long id );

	void deleteList( List< Long > idList );
}
