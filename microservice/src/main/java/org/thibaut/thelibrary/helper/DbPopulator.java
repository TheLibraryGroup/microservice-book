package org.thibaut.thelibrary.helper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.documentrepository.BookElasticsearchRepository;
import org.thibaut.thelibrary.repository.*;
import org.thibaut.thelibrary.document.BookDocument;

import java.io.IOException;
import java.util.*;

@Component
@AllArgsConstructor
@Slf4j
public class DbPopulator implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final BooksOfLibrariesRepository booksOfLibrariesRepository;
	private final CoordinatesRepository coordinatesRepository;
	private final EditorRepository editorRepository;
	private final LibraryRepository libraryRepository;
	private final CategoryRepository categoryRepository;

	private final BookElasticsearchRepository bookElasticsearchRepository;
	private final RestHighLevelClient elasticsearchClient;


	@Override
	public void run( String... args ) throws Exception {

//		deleteAllThenPopulate( );

		testElastic();

	}

	private void testElastic() throws IOException {

		GetIndexRequest getIndexRequest = new GetIndexRequest("books");
		boolean indexExists = elasticsearchClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
		log.info( "BOOK DOCUMENT INDEX CREATED : " + String.valueOf( indexExists ));

		bookElasticsearchRepository.deleteAll();

		Set<BookDocument> bookSet = new HashSet<>();

		Random random = new Random();

//		for ( int i = 0 ; i < 50  ; i++ ) {
//			bookSet.add( BookDocument.builder()
//					             .title( String.valueOf( i ) )
//					             .language( Arrays.asList( "French", "English", "German" ).get( random.nextInt(3) ) )
//								 .summary(  )
//					             .build() );
//		}

		//		//-----POPULATE BOOKS

		Set< BookDocument > booksLibrary1 = new HashSet<>();
		booksLibrary1.add( BookDocument.builder()
				                   .title( "Le cycle de Fondation, I : Fondation" )
				                   .categoryList( Collections.singletonList( "Science-fiction" ) )
				                   .authorList( Collections.singletonList( "Isaac Asimov" ) )
				                   .editorList( Collections.singletonList( "Gallimard" ) )
				                   .nbOfPages( 416 )
				                   .language( "French")
				                   .summary( "En ce début de treizième millénaire, l'Empire n'a jamais été aussi puissant, aussi étendu à travers toute la galaxie. C'est dans sa capitale, Trantor, que l'éminent savant Hari Seldon invente la psychohistoire, une science nouvelle permettant de prédire l'avenir. Grâce à elle, Seldon prévoit l'effondrement de l'Empire d'ici cinq siècles, suivi d'une ère de ténèbres de trente mille ans. Réduire cette période à mille ans est peut-être possible, à condition de mener à terme son projet : la Fondation, chargée de rassembler toutes les connaissances humaines. Une entreprise visionnaire qui rencontre de nombreux et puissants détracteurs..." )
				                   .isbn( 2070360539L )
				                   .build());
		booksLibrary1.add( BookDocument.builder()
				                   .title( "Antigone" )
				                   .categoryList( Collections.singletonList( "Litterature" ) )
				                   .authorList( Arrays.asList( "Jean Anouilh", "Sophocle" ) )
				                   .editorList( Collections.singletonList( "Poche" ) )
				                   .publicationDate( DateTime.parse( "2008-03-13" ) )
				                   .nbOfPages( 128 )
				                   .language( "French")
				                   .summary( "Pour avoir enterré son frère rebelle, Antigone doit être punie de mort. Le tyran Créon refuse de revenir sur sa décision malgré les lamentations des vieillards de Thèbes et les supplications de son propre fils Hémon, fiancé d’Antigone. Seuls les présages de Tirésias le feront changer d’avis, mais il sera déjà trop tard…" )
				                   .isbn( 9782710381419L )
				                   .build());
		booksLibrary1.add( BookDocument.builder()
				                   .title( "Le Siècle du populisme - Histoire, théorie, critique" )
				                   .categoryList( Arrays.asList( "History", "Education" ) )
				                   .authorList( Collections.singletonList( "Pierre Rosanvallon" ) )
				                   .editorList( Collections.singletonList( "Seuil" ) )
				                   .nbOfPages( 288 )
				                   .language( "French")
				                   .summary( "Le phénomène du populisme n'a pas encore été véritablement pensé. C'est en effet surtout à caractériser sociologiquement les électeurs populistes que se sont attachés la plupart des livres sur le sujet ; ou à discuter ce dont il est le symptôme (le désenchantement démocratique, les inégalités galopantes, la constitution d'un monde des invisibles, etc.) ; ou encore à sonner le tocsin sur la menace qu'il représenterait. Quel curieux millénaire")
				                   .isbn( 2021401928L )
				                   .build());
		booksLibrary1.add( BookDocument.builder()
				                   .title( "Batch Cooking with Thermomix" )
				                   .categoryList( Arrays.asList( "Education", "Entertainment" ) )
				                   .authorList( Collections.singletonList( "Bérangère Abraham" ) )
				                   .editorList( Collections.singletonList( "Larousse" ) )
				                   .nbOfPages( 288 )
				                   .language( "English")
				                   .isbn( 2035982022L )
				                   .build());
		booksLibrary1.add( BookDocument.builder()
				                   .title( "Le petit prince" )
				                   .categoryList( Collections.singletonList( "Litterature" ) )
				                   .authorList( Collections.singletonList( "Antoine de Saint-Exupéry" ) )
				                   .editorList( Collections.singletonList( "Gallimard Jeunesse" ) )
				                   .nbOfPages( 120 )
				                   .language( "French")
				                   .summary( "Le premier soir, je me suis donc endormi sur le sable à mille milles de toute terre habitée. J'étais bien plus isolé qu'un naufragé sur un radeau au milieu de l'océan. Alors, vous imaginez ma surprise, au lever du jour, quand une drôle de petite voix m'a réveillé. Elle disait : \"S'il vous plaît... dessine-moi un mouton !\" J'ai bien regardé. Et j'ai vu ce petit bonhomme tout à fait extraordinaire qui me considérait gravement...")
				                   .isbn( 9782070612758L )
				                   .build());

		bookElasticsearchRepository.saveAll( booksLibrary1 );
	}

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
}
