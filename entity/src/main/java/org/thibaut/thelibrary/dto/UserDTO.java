package org.thibaut.thelibrary.dto;

import lombok.*;
import org.joda.time.DateTime;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {

	private Long id;

	private String password;
	private String firstName;
	private String lastName;
	private String userName;
	private DateTime registrationDate;

	private List< RoleDTO > roleList;

	private CoordinatesDTO coordinates;

	private List< LoanDTO > loanList;

}
