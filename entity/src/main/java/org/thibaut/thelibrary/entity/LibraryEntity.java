package org.thibaut.thelibrary.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "library")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LibraryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_generator")
	@SequenceGenerator(name="library_generator", sequenceName = "library_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String name;

	@OneToOne
	@JoinColumn(name = "coordinates_id")
	private CoordinatesEntity coordinates;

	@ManyToMany(mappedBy = "libraryList" )
	private List< BookEntity > bookList;

}
