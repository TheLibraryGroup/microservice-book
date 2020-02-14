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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String street;
	private String streetNumber;
	private String additionalInformation;
	private String city;
	private Long postalCode;
	private String phone;
	private String email;


	@OneToOne(mappedBy = "coordinates")
	private UserEntity user;

	@OneToOne(mappedBy = "coordinates")
	private EditorEntity editor;

	@OneToOne(mappedBy = "coordinates")
	private LibraryEntity library;

}
