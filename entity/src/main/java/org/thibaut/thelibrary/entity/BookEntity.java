package org.thibaut.thelibrary.entity;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
	@SequenceGenerator(name="book_generator", sequenceName = "book_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String title;

	@ManyToMany
	@JoinTable(
			name = "categories_of_books",
			joinColumns = { @JoinColumn(name = "book_id") },
			inverseJoinColumns = { @JoinColumn(name = "category_id") } )
	private List< CategoryEntity > categoryList;

	private String language;

	private Long isbn;

	private DateTime publicationDate;

	private Integer numberOfPages;

	@ManyToMany(mappedBy = "bookList")
	private List< AuthorEntity > authorList;

	@ManyToMany
	@JoinTable(
			name = "books_of_libraries",
			joinColumns = { @JoinColumn(name = "book_id") },
			inverseJoinColumns = { @JoinColumn(name = "library_id") } )
	private List< LibraryEntity > libraryList;

	@ManyToOne
	@JoinColumn(name = "editor_id")
	private EditorEntity editor;

}
