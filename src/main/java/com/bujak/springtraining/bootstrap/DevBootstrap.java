package com.bujak.springtraining.bootstrap;

import com.bujak.springtraining.model.Author;
import com.bujak.springtraining.model.Book;
import com.bujak.springtraining.model.Publisher;
import com.bujak.springtraining.repository.AuthorRepository;
import com.bujak.springtraining.repository.BookRepository;
import com.bujak.springtraining.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

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

    private void initData() {

        Publisher superNowa = new Publisher("SuperNOWA", "Warszawa");
        publisherRepository.save(superNowa);
        Publisher isa = new Publisher("ISA", "Warszawa");
        publisherRepository.save(isa);

        Author knaak = new Author("Richard A.", "Knaak");
        authorRepository.save(knaak);
        Author sapkowski = new Author("Andrzej", "Sapkowski");
        authorRepository.save(sapkowski);

        Book witcher1 = new Book("The Last wish", "ISBN 83-7054-061-9", superNowa);
        Book dayOfDragon = new Book("Day of the Dragon", "ISBN 0671041525", isa);
        Book witcher2 = new Book("Sword of destiny", "ISBN 83-7054-037-6", superNowa);

        sapkowski.getBooks().add(witcher1);
        sapkowski.getBooks().add(witcher2);
        witcher1.getAuthors().add(sapkowski);
        witcher2.getAuthors().add(sapkowski);
        knaak.getBooks().add(dayOfDragon);
        dayOfDragon.getAuthors().add(knaak);

        bookRepository.save(dayOfDragon);
        bookRepository.save(witcher1);
        bookRepository.save(witcher2);

    }
}
