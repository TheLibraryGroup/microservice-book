package org.thibaut.thelibrary.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CategoryDTO {

	private Long id;

	private String category;

//	@JsonBackReference
	private List< BookDTO > bookList;
}
