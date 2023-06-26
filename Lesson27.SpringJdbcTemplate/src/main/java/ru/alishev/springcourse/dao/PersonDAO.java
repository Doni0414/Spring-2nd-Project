package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;

import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
public class PersonDAO {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public PersonDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Person> index() {
//        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
//    }
//
//    public Person show(int id) {
//        return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
//                .stream().findAny().orElse(null);
//    }
//
//    public void save(Person person) {
//        jdbcTemplate.update("INSERT INTO Person(fio, birthdate) VALUES(?, ?)", person.getFio(), person.getBirthdate());
//    }
//
//    public void update(int id, Person updatedPerson) {
//        jdbcTemplate.update("UPDATE Person SET fio = ?, birthdate = ? WHERE id = ?",
//                updatedPerson.getFio(),
//                updatedPerson.getBirthdate(),
//                updatedPerson.getId());
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
//    }
//    public List<Book> allBooks(int id){
//        return jdbcTemplate.query("SELECT id, title, author, date FROM Book " +
//                "Inner Join Book_of ON Book.id = Book_of.book_id WHERE person_id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
//    }
//    public Person showByFio(String fio){
//        return jdbcTemplate.query("SELECT * FROM Person WHERE fio = ?",
//                new Object[]{fio}, new BeanPropertyRowMapper<>(Person.class))
//                .stream().findAny().orElse(null);
//    }
}
