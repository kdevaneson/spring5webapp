package bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import Repository.AuthorRepository;
import Repository.BookRepository;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}
	
	private void initData() {
		Author eric = new Author("Eric","Contana");
		Book ddd = new Book("D of the DD", "1234", "Harper Collins");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		
		Author ron = new Author ("Someone", "Something");
		Book noEJB = new Book("J2EE Development", "2344", "Workx");
		ron.getBooks().add(noEJB);
		
		authorRepository.save(ron);
		bookRepository.save(noEJB);
		
	}
	

}
