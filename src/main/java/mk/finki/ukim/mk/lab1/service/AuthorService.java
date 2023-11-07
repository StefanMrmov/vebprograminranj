package mk.finki.ukim.mk.lab1.service;
import mk.finki.ukim.mk.lab1.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService{
    List<Author> listAuthors();
    Optional<Author> findById(Long id);
}
