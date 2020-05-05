package org.thibaut.thelibrary.dto.document;

import lombok.*;
import org.thibaut.thelibrary.dto.AuthorDTO;
import org.thibaut.thelibrary.dto.CategoryDTO;
import org.thibaut.thelibrary.dto.EditorDTO;
import org.thibaut.thelibrary.dto.LibraryDTO;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookDocDTO {

	private Long id;

	private String title;

	private List< String > categoryList;

	private String language;

	private Long isbn;

	private String publicationDate;

	private Integer numberOfPages;

	private List< String > authorList;

	private List< String > libraryList;

	private String editor;

}
