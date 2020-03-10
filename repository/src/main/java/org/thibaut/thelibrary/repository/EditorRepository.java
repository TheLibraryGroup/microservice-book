package org.thibaut.thelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.entity.EditorEntity;

import java.util.List;

@Repository
public interface EditorRepository extends JpaRepository< EditorEntity, Long > {

	List<EditorEntity> findEditorEntitiesByNameContains( String name);
}
