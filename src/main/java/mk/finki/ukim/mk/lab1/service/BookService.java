package mk.finki.ukim.mk.lab1.service;
import mk.finki.ukim.mk.lab1.model.Author;
import mk.finki.ukim.mk.lab1.model.Book;

import java.util.List;

public interface BookService{
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
}