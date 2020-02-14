package org.thibaut.thelibrary.helper;

import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.entity.*;
import org.thibaut.thelibrary.repository.*;
import org.thibaut.thelibrary.service.contract.PasswordService;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DbPopulator implements CommandLineRunner {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordService passwordService;
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private BooksOfLibrariesRepository booksOfLibrariesRepository;
	private CoordinatesRepository coordinatesRepository;
	private EditorRepository editorRepository;
	private LibraryRepository libraryRepository;
	private LoanRepository loanRepository;
	private CategoryRepository categoryRepository;


	@Override
	public void run( String... args ) throws Exception {

//		deleteAllThenPopulate( );

	}

	private void deleteAllThenPopulate( ) {
		System.out.println( "CONSUMER APP RUN" );

		//-----CLEAN DB

		this.userRepository.deleteAll();
		this.coordinatesRepository.deleteAll();
		this.roleRepository.deleteAll();
		this.libraryRepository.deleteAll();
		this.bookRepository.deleteAll();
		this.categoryRepository.deleteAll();
		this.booksOfLibrariesRepository.deleteAll();


		//-----POPULATE USER_ROLES

		List< RoleEntity > roles = new ArrayList<>();

		roles.add( RoleEntity.builder().role( "ROLE_USER" ).build() );

		this.roleRepository.saveAll( roles );


		//-----POPULATE USERS

		List< UserEntity > userEntities = new ArrayList<>(  );

		//pwd = 1235
		userEntities.add( UserEntity.builder()
							.firstName( "John")
							.lastName( "Doe")
							.userName( "TheJohn")
							.password( passwordService.crypt( "1235"))
				           .registrationDate( DateTime.now())
				           .build());


		//-----SET ROLE

		List< RoleEntity > rolesUser1 = new ArrayList<>();
		rolesUser1.add( this.roleRepository.findByRoleLike( "%USER" ) );

		userEntities.get( 0 ).setRoleList( rolesUser1 );


		//-----POPULATE COORDINATES OF USERS

		List< CoordinatesEntity > coordinatesUsers = new ArrayList<>();
		coordinatesUsers.add( CoordinatesEntity.builder()
									.email( "john@gmail.com" )
									.build());

		userEntities.get( 0 ).setCoordinates( coordinatesUsers.get( 0 ) );

		this.coordinatesRepository.saveAll( coordinatesUsers );


		//-----SAVE ALL USERS

		this.userRepository.saveAll( userEntities );


		//-----POPULATE LIBRARIES

		List< LibraryEntity > libraries = new ArrayList<>();

		libraries.add( LibraryEntity.builder()
								.name( "Library1" )
								.build());
		libraries.add( LibraryEntity.builder()
				               .name( "Library2" )
				               .build());

		this.libraryRepository.saveAll( libraries );


		//-----POPULATE COORDINATES OF LIBRARIES

		List< CoordinatesEntity > coordinatesLibraries = new ArrayList<>();
		coordinatesLibraries.add( CoordinatesEntity.builder()
				                      .email( "librariry1@gmail.com" )
				                      .build());
		coordinatesLibraries.add( CoordinatesEntity.builder()
				                          .email( "librariry2@gmail.com" )
				                          .build());

		libraries.get( 0 ).setCoordinates( coordinatesLibraries.get( 0 ) );
		libraries.get( 1 ).setCoordinates( coordinatesLibraries.get( 1 ) );

		this.coordinatesRepository.saveAll( coordinatesLibraries );


		//-----POPULATE BOOKS

		List< BookEntity > booksLibrary1 = new ArrayList<>();
		booksLibrary1.add( BookEntity.builder()
									.title( "Book1" )
				                    .numberOfPages( 145 )
				                    .language( "English")
									.libraryList( libraries )
									.build());

		this.bookRepository.saveAll( booksLibrary1 );

		//-----POPULATE STYLE

		List<CategoryEntity> styles = new ArrayList<>();
		styles.add( CategoryEntity.builder()
						.category( "CHILDREN" )
						.build());
		styles.add( CategoryEntity.builder()
				            .category( "CULTURE" )
				            .build());
		styles.add( CategoryEntity.builder()
				            .category( "EDUCATION" )
				            .build());
		styles.add( CategoryEntity.builder()
				            .category( "FANTASY" )
				            .build());
		styles.add( CategoryEntity.builder()
				            .category( "LITERATURE&FICTION" )
				            .build());
		this.categoryRepository.saveAll( styles );

		//-----SET STYLE OF BOOK
		List<CategoryEntity> stylesBook1 = new ArrayList<>();
		stylesBook1.add( this.categoryRepository.findAll().get( 1 ) );
		stylesBook1.add( this.categoryRepository.findAll().get( 2 ) );
		BookEntity book = this.bookRepository.findAll().get( 0 );
		book.setCategoryList( stylesBook1 );
		this.bookRepository.save( book );


		//-----SET STOCK OF BOOKS
//		BookLibraryId bookLibraryId = new BookLibraryId(1,1);

		List<BooksOfLibraries> booksOfLibraries = booksOfLibrariesRepository.findAll();
		booksOfLibraries.get( 0 ).setStock( 5 );
		this.booksOfLibrariesRepository.saveAll( booksOfLibraries );
	}
}
