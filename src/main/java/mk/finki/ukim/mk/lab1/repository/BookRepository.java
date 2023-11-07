package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.Author;
import mk.finki.ukim.mk.lab1.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class BookRepository {
    public static List<Book> knigi;

    public BookRepository(){
        knigi=new ArrayList<>();
       knigi.add(new Book("978-0739324133", "The Da Vinci Code", "Mystery", 2003,new ArrayList<>()));
        knigi.add(new Book("978-0439023481", "Harry Potter and the Deathly Hallows", "Fantasy", 2007,new ArrayList<>()));
       knigi.add(new Book("978-0671027346", "The Lord of the Rings", "Fantasy", 1954,new ArrayList<>())) ;
        knigi.add(new Book("978-1400032717", "The Kite Runner", "Drama", 2003,new ArrayList<>()));
        knigi.add(new Book("978-0743247542", "Angels & Demons", "Mystery", 2000,new ArrayList<>()));
    }
    public List<Book> findAll(){
        return knigi;
    }
    public Book findByIsbn(String isbn){
        return knigi.stream().filter(r ->r.getIsbn().equals(isbn)).findFirst().get();
    }

  public Author addAuthorToBook(Author author, Book book){
book.getAuthors().add(author);
return author;
    }
}
