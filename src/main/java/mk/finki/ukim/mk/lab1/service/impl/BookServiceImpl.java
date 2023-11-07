package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.Author;
import mk.finki.ukim.mk.lab1.model.Book;
import mk.finki.ukim.mk.lab1.repository.AuthorRepository;
import mk.finki.ukim.mk.lab1.repository.BookRepository;
import mk.finki.ukim.mk.lab1.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listBooks() {
       return bookRepository.findAll();
    }

    @Override
    public void deleteauthors(String isbn) {
         bookRepository.findByIsbn(isbn).setAuthors(new ArrayList<>());
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
      Book e= bookRepository.findByIsbn(isbn);
      Author a=authorRepository.findById(authorId).orElse(null);
      return bookRepository.addAuthorToBook(a,e);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
