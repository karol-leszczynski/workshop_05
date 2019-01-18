package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.model.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,
                "9788324631766"
                ,
                "Thinking in Java"
                ,
                "Bruce Eckel"
                ,
                "Helion"
                ,
                "programming");
    }

    @RequestMapping("/")
    public List<Book> bookDeliver(){
        return memoryBookService.getList();
    }

    @RequestMapping("/{id}")
    public Book oneBookDeliver(@PathVariable long id){
        return memoryBookService.getBook(id);
    }

    @RequestMapping(path = "/", method = {RequestMethod.POST})
    public void addBook (@RequestBody Book newBook){
        memoryBookService.addBook(newBook);
    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.PUT})
    public void updateBook (@PathVariable long id, @RequestBody Book editedBook){
        memoryBookService.udpadeBook(id, editedBook);
    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.DELETE})
    public void removeBook (@PathVariable long id){
        memoryBookService.deleteBook(id);
    }


}