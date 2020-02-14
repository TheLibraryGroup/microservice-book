package org.thibaut.thelibrary.entity.projection;

import org.joda.time.DateTime;
import org.springframework.data.rest.core.config.Projection;
import org.thibaut.thelibrary.dto.AuthorDTO;
import org.thibaut.thelibrary.dto.EditorDTO;
import org.thibaut.thelibrary.dto.LibraryDTO;
import org.thibaut.thelibrary.dto.LoanDTO;
import org.thibaut.thelibrary.entity.BookEntity;
import org.thibaut.thelibrary.entity.CategoryEntity;

import java.util.List;

@Projection(name = "categoryProjection", types = CategoryEntity.class )
public interface CategoryProjection {

	public Long getId( );

	public String getCategory( );

}
