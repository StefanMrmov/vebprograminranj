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

@WebServlet(name = "Book-detail",urlPatterns = "/bookDetails")
public class BookDetails extends HttpServlet {
    private final BookService bookService;
    private final AuthorService authorService;
    private final SpringTemplateEngine springTemplateEngine;

    public BookDetails(BookService bookService, AuthorService authorService, SpringTemplateEngine springTemplateEngine) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);
        String isbn=req.getParameter("isbn");//parametar od korisnik, nekoja brojka vo slucajov
        Book book=bookService.findBookByIsbn(isbn);//ja naogame knigata so isbnot od korisnikot
        webContext.setVariable("book",book);//ja pravime varijablata "book" od htmlot da bide knigata so isbnot koj go otkrivme
        springTemplateEngine.process("bookDetails.html",webContext,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
