package org.thibaut.thelibrary.dto;

import lombok.*;

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
public class EditorDTO {

	private Long id;
	private String name;

	private CoordinatesDTO coordinates;

//	@JsonBackReference
//	@JsonManagedReference
	private List< BookDTO > bookList;

}
