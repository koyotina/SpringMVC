package omg.myproject.web;

import omg.myproject.domain.Book;
import omg.myproject.service.AuthorService;
import omg.myproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class BookController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView homePage() {
        return new ModelAndView("books");
    }

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public ModelAndView indexPage() {
        return new ModelAndView("books");
    }

    @RequestMapping (value = "/books", method = RequestMethod.GET)
    public void showAllBooks(Model model) {
        model.addAttribute("book", bookService.getAllBooks());
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.GET)
    public ModelAndView addBook() {
        ModelAndView mav = new ModelAndView("add-book");
        Book book = new Book();
        mav.getModelMap().put("addbook", book);
        mav.getModelMap().put("author", authorService.getAllAuthors());
        return mav;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("books") Book book) {
        bookService.addBook(book);
        return "redirect:books";
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.GET)
    public ModelAndView updateBook(@RequestParam("bookId")Integer bookId) {
        ModelAndView mav = new ModelAndView("update-book");
        Book book = bookService.getTargetBookById(bookId);
        mav.getModelMap().put("updbook", book);
        mav.getModelMap().put("author", authorService.getAllAuthors());
        return mav;
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateExistingPayment(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:books";
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("bookId")Integer bookId)
    {
        bookService.deleteBook(bookId);
        ModelAndView mav = new ModelAndView("redirect:books");
        return mav;
    }
}
