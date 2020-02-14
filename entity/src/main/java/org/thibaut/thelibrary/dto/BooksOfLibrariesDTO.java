package org.thibaut.thelibrary.dto;

import lombok.*;
import org.thibaut.thelibrary.entity.BookLibraryIdDTO;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BooksOfLibrariesDTO {

	private BookLibraryIdDTO id;

	private BookDTO book;

	private LibraryDTO library;

	private Integer stock;

}
