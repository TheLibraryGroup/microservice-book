package org.thibaut.thelibrary.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "coordinates")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CoordinatesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coordinates_generator")
	@SequenceGenerator(name="coordinates_generator", sequenceName = "coordinates_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String street;
	private String streetNumber;
	private String additionalInformation;
	private String city;
	private Long postalCode;
	private String phone;
	private String email;


	@OneToOne(mappedBy = "coordinates")
	private EditorEntity editor;

	@OneToOne(mappedBy = "coordinates")
	private LibraryEntity library;

}
