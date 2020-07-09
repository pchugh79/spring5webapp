package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    AuthorRepository ar;

    @Autowired
    BookRepository br;

    public BootstrapData() {
    }

    @Override
    public void run(String... args) throws Exception {
        Author pankaj = new Author("Pankaj","Chugh",new ArrayList<Book>());
        Book book = new Book("Java 5","ISBN12345", new ArrayList<>());
        pankaj.getBooks().add(book);
        book.getAuthors().add(pankaj);
        ar.save(pankaj);
        br.save(book);

        Author pankaj1 = new Author("Pankaj1","Chugh1",new ArrayList<Book>());
        Book book1 = new Book("Java 51","ISBN12345", new ArrayList<>());
        pankaj1.getBooks().add(book1);
        book1.getAuthors().add(pankaj1);
        ar.save(pankaj1);
        br.save(book1);

        System.out.println(ar.count());
    }
}
