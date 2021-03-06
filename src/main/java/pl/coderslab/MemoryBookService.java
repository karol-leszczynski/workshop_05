package pl.coderslab;

import org.springframework.stereotype.Service;
import pl.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {

    private List<Book> list;

    public void addBook (Book book){
        list.add(book);
    }

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L,
                "9788324631766"
                ,
                "Thinking in Java"
                ,
                "Bruce Eckel"
                ,
                "Helion"
                ,
                "programming"));
        list.add(new Book(2L,
                "9788324627738"
                ,
                "Rusz glowa, Java."
                ,
                "Sierra Kathy, Bates Bert"
                ,
                "Helion"
                ,
                "programming"));
        list.add(new Book(3L,
                "9780130819338"
                ,
                "Java 2. Podstawy"
                ,
                "Cay Horstmann, Gary Cornell"
                ,
                "Helion"
                ,
                "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public Book getBook (long id){
        Book bookx = null;
        for (Book book:getList()) {
            if (book.getId()==id){
                bookx = book;
            }
        }
        return bookx;
    }

    public void udpadeBook (long id, Book editedBook){
        Book exitingBook = getBook(id);
        exitingBook.setIsbn(editedBook.getIsbn());
        exitingBook.setTitle(editedBook.getTitle());
        exitingBook.setAuthor(editedBook.getAuthor());
        exitingBook.setPublisher(editedBook.getPublisher());
        exitingBook.setType(editedBook.getType());

    }

    public void deleteBook (long id){
        Book bookToRemove = null;
        for (Book book : list) {
            if (book.getId()==id){
                bookToRemove = book;
            }
        }
        if (bookToRemove!=null) {
            list.remove(bookToRemove);
        }
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
