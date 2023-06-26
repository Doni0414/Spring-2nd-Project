package ru.alishev.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.services.BookService;
import ru.alishev.springcourse.services.PersonService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final PersonService personService;

    @Autowired
    public BookController(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }
    @GetMapping()
    public String index(@RequestParam(value = "page", required = false) Integer page,
                        @RequestParam(value = "books_per_page", required = false) Integer books_per_page,
                        @RequestParam(value = "sort_by_year", required = false) boolean sort_by_year,
                        Model model){
        List<Book> books;
        if (page == null || books_per_page == null)
            books = bookService.findAll(sort_by_year);
        else
            books = bookService.findAll(page, books_per_page, sort_by_year);
        model.addAttribute("books", books);
        return "/books/index";
    }
    @GetMapping("/search")
    public String searchByTitle(@RequestParam(value = "title", required = false) String title, Model model){
       if (title == null){
           model.addAttribute("books", new ArrayList<Book>());
       }else{
           model.addAttribute("books", bookService.findBooksByTitleStartingWith(title));
       }
        return "/books/search";
    }
    @GetMapping("/new")
    public String createBook(@ModelAttribute("book") Book book){
        return "/books/new";
    }
    @PostMapping("/new/createBook")
    public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/books/new";
        }
        bookService.save(book);
        return "redirect:/books";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        Book book = bookService.findById(id);
        System.out.println(book.getOrderedAt() + " " + book.isExpired());
        model.addAttribute("book", book);
        Person person = book.getOwner() == null ? new Person() : book.getOwner();
        model.addAttribute("person", person);
        model.addAttribute("people", personService.findAll());
        return "/books/show";
    }
    @GetMapping("/{id}/edit")
    public String getEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookService.findById(id));
        return "/books/edit";
    }
    @PostMapping("/{id}/edit")
    public String postEdit(@PathVariable("id") int id, @ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/books/edit";
        }
        bookService.update(id, book);
        return "redirect:/books/" + id;
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        bookService.delete(id);
        return "redirect:/books";
    }
    @PostMapping("/{id}/order")
    public String makeOrder(@PathVariable("id") int book_id, @ModelAttribute("person") Person person){
        bookService.makeOrder(book_id, person.getId());
        return "redirect:/books/" + book_id;
    }
    @PostMapping("/{id}/makeFree")
    public String makeFree(@PathVariable("id") int id){
        bookService.makeFree(id);
        return "redirect:/books/" + id;
    }
}
