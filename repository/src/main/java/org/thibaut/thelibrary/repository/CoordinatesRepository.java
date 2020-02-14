package org.thibaut.thelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.entity.CoordinatesEntity;

@Repository
public interface CoordinatesRepository extends JpaRepository< CoordinatesEntity, Long > {
}
