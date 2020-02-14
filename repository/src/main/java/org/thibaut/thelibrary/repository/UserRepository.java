package org.thibaut.thelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository< UserEntity, Long > {

	UserEntity findByUserName( String username );

	@Query( "SELECT user FROM UserEntity AS user JOIN  user.coordinates AS coordinates WHERE coordinates.email = :email" )
	UserEntity findByEmail( @Param( "email" ) String email );

}
