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

	@Override
	public EditorDTO findById( Long id ){
		return EditorMapper.INSTANCE.toDTO( editorRepository.getOne( id ) );
	}


	@Override
	public List< EditorDTO > findByName( String name ){
		return EditorMapper.INSTANCE.toDTOList( editorRepository.findEditorEntitiesByNameContains( name ));
	}


	@Override
	public List<EditorDTO> findAll( ){
		return EditorMapper.INSTANCE.toDTOList( editorRepository.findAll());
	}


	@Override
	public EditorDTO save( EditorDTO bookDTO ){
		editorRepository.save( EditorMapper.INSTANCE.toEntity( bookDTO/*, new CycleAvoidingMappingContext()*/ ) );
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
