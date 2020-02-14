package org.thibaut.thelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.entity.EditorEntity;

@Repository
public interface EditorRepository extends JpaRepository< EditorEntity, Long > {
}
