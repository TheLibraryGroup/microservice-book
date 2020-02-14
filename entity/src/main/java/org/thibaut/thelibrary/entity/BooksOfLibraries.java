package org.thibaut.thelibrary.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books_of_libraries")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BooksOfLibraries {

	@EmbeddedId
	private BookLibraryIdDTO id;

	@ManyToOne
	@MapsId("bookId")
	private BookEntity book;

	@ManyToOne
	@MapsId("libraryId")
	private LibraryEntity library;

	private Integer stock;
}
