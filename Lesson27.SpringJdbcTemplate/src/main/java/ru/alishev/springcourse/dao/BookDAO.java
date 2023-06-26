package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Component
public class BookDAO {
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public BookDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    public List<Book> index(){
//        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
//    }
//    public Book show(int id){
//        return jdbcTemplate.query("SELECT * FROM Book WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
//                .stream().findAny().orElse(null);
//    }
//    public void save(Book book){
//        jdbcTemplate.update("INSERT INTO Book(title, author, date) VALUES(?, ?, ?)",
//                book.getTitle(), book.getAuthor(), book.getDate());
//    }
//    public void update(int id, Book book){
//        jdbcTemplate.update("UPDATE Book SET title = ?, author = ?, date = ? WHERE id = ?",
//                book.getTitle(), book.getAuthor(), book.getDate(), book.getId());
//    }
//    public void delete(int id){
//        jdbcTemplate.update("DELETE FROM Book WHERE id = ?", id);
//    }
//    public Person getPerson(int id){
//        return jdbcTemplate.query("SELECT id, fio, birthdate FROM Person INNER JOIN Book_of ON Person.id = Book_of.person_id WHERE Book_of.book_id = ?", new Object[]{id},
//                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(new Person());
//    }
//    public void makeOrder(int book_id, int person_id){
//        jdbcTemplate.update("INSERT INTO Book_of(book_id, person_id) VALUES(?, ?)", book_id, person_id);
//    }
//    public void makeFree(int id){
//        jdbcTemplate.update("DELETE FROM Book_of WHERE book_id = ?", id);
//    }
}
