package omg.myproject.web;

import omg.myproject.domain.Author;
import omg.myproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public String addPayment(@ModelAttribute("authors") Author author) {
        authorService.addAuthor(author);
        return "redirect:authors";
    }

    @RequestMapping (value = "/authors", method = RequestMethod.GET)
    public void showAllBooks(Model model) {
        model.addAttribute("author", authorService.getAllAuthors());
    }

    @RequestMapping(value = "/add-author", method = RequestMethod.GET)
    public ModelAndView addAuthor() {
        ModelAndView mav = new ModelAndView("add-author");
        Author author = new Author();
        mav.getModelMap().put("addauthor", author);
        return mav;
    }
}
