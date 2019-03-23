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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired //gives an instance of this class by the framework by dependency injection
    private UserDao userDao;

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "User Registration");
        model.addAttribute("user", new User());
        return "user/add";
    }
    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String submitAddUserForm(@ModelAttribute @Valid User user, Model model, Errors errors, String verify){
        List<User> nameTaken = userDao.findByUserName((user.getUserName()));

        if (!errors.hasErrors() && user.getPassword().equals(verify) && nameTaken.isEmpty()){
            model.addAttribute("user", user);
            userDao.save(user);
            return "user/index";  //render user/index form if no errors
        }else{
            model.addAttribute("user", user);
            model.addAttribute("title", "User Registration");
            if(!user.getPassword().equals(verify)){
                model.addAttribute("passwordError", "Password must match");
                user.setPassword("");
            }
            if(!nameTaken.isEmpty()){
                model.addAttribute("nameError", "User Name is already taken");
                user.setUserName("");
            }
            return "user/add";
        }
    }

    @RequestMapping(value = "login")
    public String displayLoginForm(Model model) {
        model.addAttribute("title", "Log In");
        model.addAttribute(new User());
        return "user/login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, HttpServletResponse response) {
        List<User> usr = userDao.findByUserName(user.getUserName());
        if(usr.isEmpty()) {
            model.addAttribute("usererror", "Invalid Username");
            model.addAttribute("title", "Log In");
            return "user/login";
        }

        User signedIn = usr.get(0);
        if(signedIn.getPassword().equals(user.getPassword())) {

            Cookie ckie = new Cookie("user", user.getUserName());
            ckie.setPath("/");
            response.addCookie(ckie);
            return "redirect:/recipe";

        } else {
            model.addAttribute("passworderror", "Invalid Password");
            model.addAttribute("title", "Log In");
            return "user/login";
        }
    }

    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
            }
        }
        return "redirect:/user/login";
    }
}
