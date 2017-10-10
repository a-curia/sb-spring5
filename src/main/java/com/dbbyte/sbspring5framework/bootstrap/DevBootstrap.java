package com.dbbyte.sbspring5framework.bootstrap;

import com.dbbyte.sbspring5framework.model.Author;
import com.dbbyte.sbspring5framework.model.Book;
import com.dbbyte.sbspring5framework.model.Publisher;
import com.dbbyte.sbspring5framework.repositories.AuthorRepository;
import com.dbbyte.sbspring5framework.repositories.BookRepository;
import com.dbbyte.sbspring5framework.repositories.PublisherRepository;
import org.springframework.boot.actuate.autoconfigure.ShellProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
            // create publisher
        Publisher pub1 = new Publisher();
        pub1.setName("pub1");
        publisherRepository.save(pub1);

            // create the author
        Author eric = new Author("Eric", "Evans");
            // create the book
        Book  ddd = new Book("Domain Driven Design", "1234",  pub1 );
            // add book to author
        eric.getBooks().add(ddd);
            //add author to book
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Publisher pub2 = new Publisher();
        pub1.setName("pub2");
        publisherRepository.save(pub2);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444",  pub2 );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}