package org.thibaut.thelibrary.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.dto.CategoryDTO;
import org.thibaut.thelibrary.dto.CycleAvoidingMappingContext;
import org.thibaut.thelibrary.mapper.CategoryMapper;
import org.thibaut.thelibrary.repository.CategoryRepository;
import org.thibaut.thelibrary.service.contract.CategoryService;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	private CategoryMapper categoryMapper;

	@Override
	public CategoryDTO findById( Long id ){
		return categoryMapper.toDTO( categoryRepository.getOne( id ), new CycleAvoidingMappingContext() );
	}


	@Override
	public CategoryDTO findByName( String name ){
		return categoryMapper.toDTO( categoryRepository.findCategoryEntityByCategoryContains( name ), new CycleAvoidingMappingContext());
	}


	@Override
	public List<CategoryDTO> findAll( ){
		return categoryMapper.toDTOList( categoryRepository.findAll(), new CycleAvoidingMappingContext());
	}


	@Override
	public CategoryDTO save( CategoryDTO categoryDTO ){
		categoryRepository.save( categoryMapper.toEntity( categoryDTO, new CycleAvoidingMappingContext() ) );
		return categoryDTO;
	}


	@Override
	public void deleteById( Long id ){
		categoryRepository.deleteById( id );
	}


	@Override
	public void deleteList( List< Long > idList ){
		for ( Long id: idList ) {
			deleteById( id );
		}
	}

}
