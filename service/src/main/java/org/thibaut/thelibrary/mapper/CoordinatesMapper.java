package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.CoordinatesDTO;
import org.thibaut.thelibrary.entity.CoordinatesEntity;

import java.util.List;


@Mapper
public interface CoordinatesMapper {

	CoordinatesMapper INSTANCE = Mappers.getMapper( CoordinatesMapper.class );

	CoordinatesDTO coordionatesToDTO( CoordinatesEntity coordionatesEntity );

	List<CoordinatesDTO> coordionatesToDTOList( List< CoordinatesEntity > coordionatesEntityList );

	CoordinatesEntity coordionatesToEntity( CoordinatesDTO coordionatesDTO );

	List<CoordinatesEntity> coordionatesToEntityList( List< CoordinatesDTO > coordionatesDTOList );

}
