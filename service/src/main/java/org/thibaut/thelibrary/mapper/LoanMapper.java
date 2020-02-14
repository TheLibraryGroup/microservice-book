package org.thibaut.thelibrary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.dto.LoanDTO;
import org.thibaut.thelibrary.entity.LoanEntity;

import java.util.List;


@Mapper
public interface LoanMapper {

	LoanMapper INSTANCE = Mappers.getMapper( LoanMapper.class );

	LoanDTO loanToDTO( LoanEntity loanEntity );

	List<LoanDTO> loanToDTOList( List< LoanEntity > loanEntityList );

	LoanEntity loanToEntity( LoanDTO loanDTO );

	List<LoanEntity> loanToEntityList( List< LoanDTO > loanDTOList );

}
