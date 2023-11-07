package mk.finki.ukim.mk.lab1.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab1.model.Book;
import mk.finki.ukim.mk.lab1.service.AuthorService;
import mk.finki.ukim.mk.lab1.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "delete",urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    private final BookService bookService;
    private final AuthorService authorService;
    private final SpringTemplateEngine springTemplateEngine;


    public DeleteServlet(BookService bookService, AuthorService authorService, SpringTemplateEngine springTemplateEngine) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn=req.getSession().getAttribute("isbn").toString();
        bookService.deleteauthors(isbn);
        resp.sendRedirect("/bookDetails?isbn=" + isbn);
    }
}
