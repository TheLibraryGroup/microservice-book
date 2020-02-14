package org.thibaut.thelibrary.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookLibraryIdDTO implements Serializable {

	private Integer bookId;
	private Integer libraryId;
}
