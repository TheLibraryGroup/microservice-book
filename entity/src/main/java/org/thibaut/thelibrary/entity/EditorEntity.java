package org.thibaut.thelibrary.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "editor")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EditorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editor_generator")
	@SequenceGenerator(name="editor_generator", sequenceName = "editor_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String name;

	@OneToOne
	@JoinColumn(name = "coordinates_id")
	private CoordinatesEntity coordinates;

	@OneToMany(mappedBy = "editor", fetch = FetchType.LAZY)
	private List< BookEntity > bookList;

}
