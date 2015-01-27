package omg.myproject.web;

import omg.myproject.dao.RoleDAO;
import omg.myproject.dao.UserDAO;
import omg.myproject.dao.UserService;
import omg.myproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorisationController {
    @Autowired
    UserDAO userServise;

    @Autowired
    RoleDAO roleServise;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "error403";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "logout";
    }

    @RequestMapping (value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
        return "register";
    }


    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView mav = new ModelAndView("add-user");
        User user = new User();
        mav.getModelMap().put("adduser", user);
        mav.getModelMap().put("roles", roleServise.getAllRoles());
        return mav;
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        userServise.addUser(user);
        return "redirect:login";
    }
}
