package org.thibaut.thelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.entity.BookEntity;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository< BookEntity, Long > {


	List< BookEntity > getBooksByTitleContains( String title);
	List< BookEntity > findAllByTitleContains( String title);

	@Query("select book from BookEntity as book where book.title like :title")
	List< BookEntity > findBookByTitleContains( @Param( "title" ) String title);
}
