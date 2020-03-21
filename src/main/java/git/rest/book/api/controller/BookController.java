package git.rest.book.api.controller;

import git.rest.book.api.model.Book;
import git.rest.book.api.repository.BookRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class BookController {
    @Autowired
    private BookRepository repository;
    private JSONObject jsonObject = new JSONObject();

    public BookRepository getRepository() {
        return repository;
    }

    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/books")
    public String getAllBooks() {
        jsonObject.put("data", repository.findAll());

        return jsonObject.toString(3);
    }

    @PostMapping("/books")
    Book createBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    @GetMapping("/books/{id}")
    Book getBookById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping("books/{id}")
    Book updateBook(@RequestBody Book newBook, @PathVariable Long id) {
        return repository.findById(id).map(book -> {
            book.setName(newBook.getName());
            book.setAuthor(newBook.getAuthor());
            book.setPage(newBook.getPage());
            return repository.save(book);
        }).orElseGet(() -> {
            newBook.setId(id);
            return repository.save(newBook);
        });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
