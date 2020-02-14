package org.thibaut.thelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.entity.LibraryEntity;

@Repository
public interface LibraryRepository extends JpaRepository< LibraryEntity, Long > {
}
