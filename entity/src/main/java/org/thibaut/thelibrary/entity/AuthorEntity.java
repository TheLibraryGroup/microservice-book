package org.thibaut.thelibrary.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuthorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name="author_generator", sequenceName = "author_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String firstName;
	private String lastName;
	private String nationality;

	@ManyToMany
	@JoinTable(
			name = "authors_of_books",
			joinColumns = { @JoinColumn(name = "author_id") },
			inverseJoinColumns = { @JoinColumn(name = "book_id") } )
	private List< BookEntity > bookList;

}
