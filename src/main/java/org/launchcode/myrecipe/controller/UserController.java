package org.launchcode.myrecipe.controller;

import org.launchcode.myrecipe.models.User;
import org.launchcode.myrecipe.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired //gives an instance of this class by the framework by dependency injection
    private UserDao userDao;

    @RequestMapping(value="")
    public String index(Model model){
        //model.addAttribute("user", "userDao.findAll()");
        model.addAttribute("user", new User());
        return "user/index";
    }

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }
    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String submitAddUserForm(@ModelAttribute @Valid User user, Model model, Errors errors){

        if (errors.hasErrors()){
            model.addAttribute("user", new User());
            return "user/add";  //render user/add form if it has errors
        }

        userDao.save(user);
        model.addAttribute(user);
        return "user/index";
    }

    @RequestMapping(value = "login")
    public String displayLoginForm(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute(new User());
        return "user/login";
    }
}
