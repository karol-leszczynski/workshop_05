package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}