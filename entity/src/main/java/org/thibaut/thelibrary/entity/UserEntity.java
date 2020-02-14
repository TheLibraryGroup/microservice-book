package org.thibaut.thelibrary.entity;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String password;
	private String firstName;
	private String lastName;
	private String userName;
	private DateTime registrationDate;

	@ManyToMany
	@JoinTable(
			name = "roles_of_users",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "role_id") } )
	private List< RoleEntity > roleList;

	@OneToOne
	@JoinColumn(name = "coordinates_id")
	private CoordinatesEntity coordinates;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List< LoanEntity > loanList;


}
