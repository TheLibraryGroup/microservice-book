package org.thibaut.thelibrary.entity.projection;

import org.joda.time.DateTime;
import org.springframework.data.rest.core.config.Projection;
import org.thibaut.thelibrary.entity.BookEntity;

import java.util.List;

@Projection(name = "bookProjection", types = BookEntity.class )
public interface BookProjection {

	public Long getId();

	public String getTitle();

	public List< CategoryProjection > getCategoryList();

	public String getLanguage();

	public Long getIsbn();

	public DateTime getPublicationDate();

	public Integer getNumberOfPages();

//	public List< AuthorDTO > authorList();
//
//	public List< LibraryDTO > librarieList();
//
//	public EditorDTO editor();
//
//	public List< LoanDTO > loanList();
}
