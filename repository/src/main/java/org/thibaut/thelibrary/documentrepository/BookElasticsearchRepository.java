package org.thibaut.thelibrary.documentrepository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.document.BookDocument;

@Repository
public interface BookElasticsearchRepository extends ElasticsearchRepository< BookDocument, String> {

//	List<BookDocument> findAllByTitleContains(String title);
}
