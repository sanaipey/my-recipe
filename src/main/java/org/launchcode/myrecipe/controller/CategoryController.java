package org.launchcode.myrecipe.controller;

import org.launchcode.myrecipe.models.Category;
import org.launchcode.myrecipe.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Categories");
        model.addAttribute("categories", categoryDao.findAll());

        return "category/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCategoryForm(Model model){
        model.addAttribute("title", "Add Category");
        model.addAttribute(new Category());

        return "category/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String submitAddCategoryForm(@Valid @ModelAttribute Category category,
                                        Model model, Errors errors){

        if(errors.hasErrors()){
            model.addAttribute("title", "Add Category");
            return "category/add";
        }

        categoryDao.save(category);

        return "redirect:";

    }
}
