package org.thibaut.thelibrary.document;

import lombok.*;
import org.joda.time.DateTime;
import org.springframework.data.elasticsearch.annotations.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.Keyword;
import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Document(createIndex = false, indexName = "books", type = "book", shards = 1, replicas = 0, refreshInterval = "-1"/*, indexStoreType = "memory"*/)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDocument {

	@Id
	private String id;

//	@MultiField(
//			mainField = @Field(type = Text, fielddata = true),
//			otherFields = {
//					@InnerField(suffix = "verbatim", type = Keyword)
//			}
//	)
	private String title;

	private String language;

	private DateTime publicationDate;

	private Integer nbOfPages;

	@Field(type = Text, store = true)
	private List<String> categoryList;

	@Field(type = Text, store = true)
	private List<String> authorList;

	@Field(type = Text, store = true)
	private List<String> editorList;

	private String summary;

	private Long isbn;

}
