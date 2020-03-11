package org.thibaut.thelibrary.dto;

import lombok.*;
import org.joda.time.DateTime;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//@JsonIdentityInfo(
//		generator= ObjectIdGenerators.PropertyGenerator.class,
//		property="id")
public class BookDTO {

	private Long id;

	private String title;

	private List< CategoryDTO > categoryList;

	private String language;

	private Long isbn;

	private DateTime publicationDate;

	private Integer numberOfPages;

	private List< AuthorDTO > authorList;

	private List< LibraryDTO > libraryList;

//	@JsonManagedReference
//	@JsonBackReference
	private EditorDTO editor;

}
