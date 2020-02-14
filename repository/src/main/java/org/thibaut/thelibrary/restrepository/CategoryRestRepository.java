package org.thibaut.thelibrary.restrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.thibaut.thelibrary.entity.CategoryEntity;

import java.awt.print.Book;

@RepositoryRestResource
public interface CategoryRestRepository extends JpaRepository< CategoryEntity, Long > {
}
