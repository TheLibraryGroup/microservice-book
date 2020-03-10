//package org.thibaut.thelibrary.helper;
//
//import lombok.AllArgsConstructor;
//import org.joda.time.DateTime;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.thibaut.thelibrary.entity.*;
//import org.thibaut.thelibrary.repository.*;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Component
//@AllArgsConstructor
//public class DbPopulator implements CommandLineRunner {
//
//	private AuthorRepository authorRepository;
//	private BookRepository bookRepository;
//	private BooksOfLibrariesRepository booksOfLibrariesRepository;
//	private CoordinatesRepository coordinatesRepository;
//	private EditorRepository editorRepository;
//	private LibraryRepository libraryRepository;
//	private CategoryRepository categoryRepository;
//
//
//	@Override
//	public void run( String... args ) throws Exception {
//
////		deleteAllThenPopulate( );
//
//	}
//
//	private void deleteAllThenPopulate( ) {
//		System.out.println( "CONSUMER APP RUN" );
//
//		//-----CLEAN DB
//
//		this.coordinatesRepository.deleteAll();
//		this.bookRepository.deleteAll();
//		this.categoryRepository.deleteAll();
//		this.booksOfLibrariesRepository.deleteAll();
//		this.libraryRepository.deleteAll();
//
//
//
//
//		//-----POPULATE LIBRARIES
//
//		List< LibraryEntity > libraries = new ArrayList<>();
//
//		libraries.add( LibraryEntity.builder()
//								.name( "Library1" )
//								.build());
//		libraries.add( LibraryEntity.builder()
//				               .name( "Library2" )
//				               .build());
//
//		this.libraryRepository.saveAll( libraries );
//
//
//		//-----POPULATE COORDINATES OF LIBRARIES
//
//		List< CoordinatesEntity > coordinatesLibraries = new ArrayList<>();
//		coordinatesLibraries.add( CoordinatesEntity.builder()
//				                      .email( "librariry1@gmail.com" )
//				                      .build());
//		coordinatesLibraries.add( CoordinatesEntity.builder()
//				                          .email( "librariry2@gmail.com" )
//				                          .build());
//
//		libraries.get( 0 ).setCoordinates( coordinatesLibraries.get( 0 ) );
//		libraries.get( 1 ).setCoordinates( coordinatesLibraries.get( 1 ) );
//
//		this.coordinatesRepository.saveAll( coordinatesLibraries );
//
//		//-----POPULATE EDITOR
//
//		List<EditorEntity> editorEntities = new ArrayList<>();
//		editorEntities.add( EditorEntity.builder().name( "Folio" ).build() );
//		editorEntities.add( EditorEntity.builder().name( "La table ronde" ).build() );
//
//		editorRepository.saveAll( editorEntities );
//
//		//-----POPULATE STYLE
//
//		List<CategoryEntity> styles = new ArrayList<>();
//		styles.add( CategoryEntity.builder()
//						.category( "CHILDREN" )
//						.build());
//		styles.add( CategoryEntity.builder()
//				            .category( "CULTURE" )
//				            .build());
//		styles.add( CategoryEntity.builder()
//				            .category( "EDUCATION" )
//				            .build());
//		styles.add( CategoryEntity.builder()
//				            .category( "FANTASY" )
//				            .build());
//		styles.add( CategoryEntity.builder()
//				            .category( "LITERATURE&FICTION" )
//				            .build());
//		this.categoryRepository.saveAll( styles );
//
//		//-----SET STYLE OF BOOK
////		List<CategoryEntity> stylesBook1 = new ArrayList<>();
////		stylesBook1.add( this.categoryRepository.findAll().get( 1 ) );
////		stylesBook1.add( this.categoryRepository.findAll().get( 2 ) );
////		BookEntity book = this.bookRepository.findAll().get( 0 );
////		book.setCategoryList( stylesBook1 );
////		this.bookRepository.save( book );
//
//
//		//-----POPULATE BOOKS
//
//		List< BookEntity > booksLibrary1 = new ArrayList<>();
//		booksLibrary1.add( BookEntity.builder()
//				                   .title( "Le cycle de Fondation, I : Fondation" )
//				                   .categoryList( Collections.singletonList( this.categoryRepository.findAll( ).get( 4 ) ) )
//				                   .numberOfPages( 416 )
//				                   .language( "French")
//				                   .isbn( 2070360539L )
//				                   .editor( editorEntities.get( 0 ) )
//				                   .libraryList( libraries )
//				                   .build());
//		booksLibrary1.add( BookEntity.builder()
//				                   .title( "Antigone" )
//				                   .categoryList( Collections.singletonList( this.categoryRepository.findAll( ).get( 4 ) ) )
//				                   .numberOfPages( 128 )
//				                   .language( "French")
//				                   .isbn( 9782710381419L )
//				                   .editor( editorEntities.get( 1 ) )
//				                   .libraryList( Collections.singletonList( libraries.get( 0 ) ) )
//				                   .build());
//		booksLibrary1.add( BookEntity.builder()
//				                   .title( "Le Siècle du populisme - Histoire, théorie, critique" )
//				                   .categoryList( Collections.singletonList( this.categoryRepository.findAll( ).get( 1 ) ) )
//				                   .numberOfPages( 288 )
//				                   .language( "French").isbn( 2021401928L )
//				                   .libraryList( libraries )
//				                   .build());
//		booksLibrary1.add( BookEntity.builder()
//				                   .title( "Batch Cooking with Thermomix " )
//				                   .categoryList( Collections.singletonList( this.categoryRepository.findAll( ).get( 2 ) ) )
//				                   .numberOfPages( 288 )
//				                   .language( "English")
//				                   .isbn( 2035982022L )
//				                   .libraryList( Collections.singletonList( libraries.get( 0 ) ) )
//				                   .build());
//		booksLibrary1.add( BookEntity.builder()
//				                   .title( "Le petit prince" )
//				                   .categoryList( Collections.singletonList( this.categoryRepository.findAll( ).get( 0 ) ) )
//				                   .numberOfPages( 120 )
//				                   .language( "French").isbn( 9782070612758L )
//				                   .libraryList( libraries )
//				                   .build());
//
//		this.bookRepository.saveAll( booksLibrary1 );
//
//		//-----SET STOCK OF BOOKS
////		BookLibraryId bookLibraryId = new BookLibraryId(1,1);
//
//		List<BooksOfLibraries> booksOfLibraries = booksOfLibrariesRepository.findAll();
//		booksOfLibraries.get( 0 ).setStock( 5 );
//		this.booksOfLibrariesRepository.saveAll( booksOfLibraries );
//	}
//}
