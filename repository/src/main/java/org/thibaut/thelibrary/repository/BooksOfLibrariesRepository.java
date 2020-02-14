package org.thibaut.thelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.entity.BooksOfLibraries;

@Repository
public interface BooksOfLibrariesRepository extends JpaRepository< BooksOfLibraries, Long > {
}
