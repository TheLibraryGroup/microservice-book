package org.thibaut.thelibrary.document;

import lombok.*;
import org.joda.time.DateTime;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Document(createIndex = false, indexName = "books", type = "book", shards = 1, replicas = 0, refreshInterval = "-1"/*, indexStoreType = "memory"*/)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDocument {

	@Id
	private String id;

	private String title;

	private String language;

	private DateTime publicationDate;

	private Integer nbOfPages;

	@Field(type = FieldType.Text, store = true)
	private List<String> categoryList;

	@Field(type = FieldType.Text, store = true)
	private List<String> authorList;

	@Field(type = FieldType.Text, store = true)
	private List<String> editorList;

	private String summary;

	private Long isbn;

}
