package org.thibaut.thelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.entity.RoleEntity;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository< RoleEntity, Long > {

	List< RoleEntity > findRolesByRoleContains( String role );

	RoleEntity findByRoleLike( String role );

	@Query("SELECT user.roleList FROM UserEntity user WHERE user.userName = :userName ")
	List<RoleEntity> getRolesByUsername( @Param( "userName" ) String userName);

	@Query( "SELECT user.roleList FROM UserEntity user JOIN  user.coordinates coordinates WHERE coordinates.email = :email" )
	List<RoleEntity> getRolesByEmail( @Param( "email" ) String email);
}
