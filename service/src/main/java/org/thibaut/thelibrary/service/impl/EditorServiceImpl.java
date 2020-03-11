package org.thibaut.thelibrary.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.dto.EditorDTO;
import org.thibaut.thelibrary.mapper.EditorMapper;
import org.thibaut.thelibrary.repository.EditorRepository;
import org.thibaut.thelibrary.service.contract.EditorService;

import java.util.List;

@Service
@AllArgsConstructor
public class EditorServiceImpl implements EditorService {

	private EditorRepository editorRepository;
	private EditorMapper editorMapper;

	@Override
	public EditorDTO findById( Long id ){
		return editorMapper.toDTO( editorRepository.getOne( id ) );
	}


	@Override
	public List< EditorDTO > findByName( String name ){
		return editorMapper.toDTOList( editorRepository.findEditorEntitiesByNameContains( name ));
	}


	@Override
	public List<EditorDTO> findAll( ){
		return editorMapper.toDTOList( editorRepository.findAll());
	}


	@Override
	public EditorDTO save( EditorDTO bookDTO ){
		editorRepository.save( editorMapper.toEntity( bookDTO/*, new CycleAvoidingMappingContext()*/ ) );
		return bookDTO;
	}


	@Override
	public void deleteById( Long id ){
		editorRepository.deleteById( id );
	}


	@Override
	public void deleteList( List< Long > idList ){
		for ( Long id: idList ) {
			deleteById( id );
		}
	}

}
