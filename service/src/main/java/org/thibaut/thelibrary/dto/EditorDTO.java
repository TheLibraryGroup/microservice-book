package org.thibaut.thelibrary.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

	@JsonBackReference
	private List< BookDTO > bookList;

}
