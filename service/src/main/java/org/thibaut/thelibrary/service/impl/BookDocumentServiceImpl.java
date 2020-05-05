package org.thibaut.thelibrary.service.impl;

import lombok.AllArgsConstructor;
import org.elasticsearch.action.search.*;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.document.BookDocument;
import org.thibaut.thelibrary.documentrepository.BookElasticsearchRepository;
import org.thibaut.thelibrary.dto.BookDTO;
import org.thibaut.thelibrary.dto.document.BookDocDTO;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookDocumentServiceImpl {

	private final BookElasticsearchRepository bookElasticsearchRepository;
	private final RestHighLevelClient esearchClient;

	public List< BookDocDTO > findByTitleAndSummaryAndAuthorAndEditor(String keywords) throws IOException {

		SearchRequest searchRequest = new SearchRequest("books");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query( QueryBuilders.multiMatchQuery( keywords+"*" )
				                            .field( "title", 3 )
											.field( "categoryList" )
											.field( "authorList", 2 )
											.field( "editorList" )
											.field( "summary", ( float ) 1.5 )
											.type( MultiMatchQueryBuilder.Type.CROSS_FIELDS ) ) ;
		searchSourceBuilder.sort( "_score", SortOrder.DESC );
//		searchSourceBuilder.size(2);
		searchRequest.source(searchSourceBuilder);
		searchRequest.scroll( TimeValue.timeValueMinutes(1L));

		SearchResponse searchResponse = esearchClient.search(searchRequest, RequestOptions.DEFAULT);
		String scrollId = searchResponse.getScrollId();
		SearchHit[] searchHits = searchResponse.getHits().getHits();

		final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(1L));

//		Set< BookDocDTO > bookDocDTOSet = new HashSet<>(  );
		List< BookDocDTO > bookDocDTOList = new ArrayList<>(  );

		while (searchHits != null && searchHits.length > 0) {

			SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
			scrollRequest.scroll(scroll);
			searchResponse = esearchClient.scroll(scrollRequest, RequestOptions.DEFAULT);
			scrollId = searchResponse.getScrollId();

			for (SearchHit hit : searchHits) {
				BookDocDTO.BookDocDTOBuilder bookDTOBuilder = BookDocDTO.builder();
				String sourceAsString = hit.getSourceAsString();
				Map<String, Object> sourceAsMap = hit.getSourceAsMap();
				bookDTOBuilder.title( (String) sourceAsMap.get("title") );
				bookDTOBuilder.categoryList(((List<Object>) sourceAsMap.get("categoryList"))
						                            .stream()
						                            .map(object -> Objects.toString(object, null))
						                            .collect( Collectors.toList()));
				bookDocDTOList.add( bookDTOBuilder.build() );
//				bookDocDTOSet.add( bookDTOBuilder.build() );
			}
			searchHits = searchResponse.getHits().getHits();
		}

		ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
		clearScrollRequest.addScrollId(scrollId);
		ClearScrollResponse clearScrollResponse = esearchClient.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
		boolean succeeded = clearScrollResponse.isSucceeded();

		return bookDocDTOList;
//		return bookDocDTOSet;
	}

}
