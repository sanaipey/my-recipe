package org.launchcode.myrecipe.controller;

import org.launchcode.myrecipe.models.User;
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

        model.addAttribute(user);
        return "user/index";
    }
}
