package ru.alishev.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.repositories.BookRepository;
import ru.alishev.springcourse.repositories.PersonRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;
    private final PersonRepository personRepository;

    @Autowired
    public BookService(BookRepository bookRepository, PersonRepository personRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
    }
    public List<Book> findAll(boolean sortByYear){
        if (sortByYear)
            return bookRepository.findAll(Sort.by("date"));
        return bookRepository.findAll();
    }
    public List<Book> findAll(int page, int books_per_page, boolean sortByYear){
        if (sortByYear)
            return bookRepository.findAll(PageRequest.of(page, books_per_page, Sort.by("date"))).getContent();
        return bookRepository.findAll(PageRequest.of(page, books_per_page)).getContent();
    }

    public List<Book> findBooksByTitleStartingWith(String title){
        return bookRepository.findBooksByTitleStartingWith(title);
    }
    public Book findById(int id){
        return bookRepository.findById(id).orElse(null);
    }
    @Transactional
    public void save(Book book){
        bookRepository.save(book);
    }
    @Transactional
    public void update(int id, Book book){
        book.setId(id);
        bookRepository.save(book);
    }
    @Transactional
    public void delete(int id){
        bookRepository.deleteById(id);
    }
    public List<Book> findBooksByOwner(Person owner){
        return bookRepository.findBooksByOwner(owner);
    }
    @Transactional
    public void makeOrder(int book_id, int person_id){
        Person owner = personRepository.findById(person_id).orElse(null);
        Book book = bookRepository.findById(book_id).orElse(null);
        owner.getBooks().add(book);
        book.setOwner(owner);
        book.setOrderedAt(new Date());
    }
    @Transactional
    public void makeFree(int book_id){
        Book book = bookRepository.findById(book_id).orElse(null);
        Person person = book.getOwner();
        person.getBooks().remove(book);
        book.setOwner(null);
        book.setOrderedAt(null);
    }
}
