package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
@Repository
public class AuthorRepository {
    public static List<Author>avtori;

    public AuthorRepository(){
        avtori=new ArrayList<>();
        Author author1 = new Author(0L,"Dan", "Brown", "Dan Brown is an American author known for his thriller novels.");
        Author author2 = new Author(1L,"J.K.", "Rowling", "J.K. Rowling is a British author best known for the Harry Potter series.");
        Author author3 = new Author(2L,"J.R.R.", "Tolkien", "J.R.R. Tolkien was an English writer, poet, and philologist.");
        Author author4 = new Author(3L,"Khaled", "Hosseini", "Khaled Hosseini is an Afghan-American novelist.");
        Author author5 = new Author(4L,"Dan", "Brown", "Dan Brown is an American author known for his thriller novels.");

        avtori.add(author1);
        avtori.add(author2);
        avtori.add(author3);
        avtori.add(author4);
        avtori.add(author5);
    }

    public List<Author> findAll(){
        return avtori;
    }

    public Optional<Author> findById(Long id){
        return avtori.stream().filter(r ->r.getId().equals(id)).findFirst();
    }

}
