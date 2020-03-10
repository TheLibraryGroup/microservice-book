package org.thibaut.thelibrary.entity.projection;

import org.springframework.data.rest.core.config.Projection;
import org.thibaut.thelibrary.entity.CategoryEntity;

@Projection(name = "categoryProjection", types = CategoryEntity.class )
public interface CategoryProjection {

	public Long getId( );

	public String getCategory( );

}
