package org.launchcode.myrecipe.controller;

import org.launchcode.myrecipe.models.Category;
import org.launchcode.myrecipe.models.Recipe;
import org.launchcode.myrecipe.models.data.CategoryDao;
import org.launchcode.myrecipe.models.data.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import javax.validation.Valid;

@Controller
@RequestMapping("recipe")
public class RecipeController {

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title","My Recipes");
        model.addAttribute("recipes", recipeDao.findAll());

        return "recipe/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddRecipeForm(Model model){
        model.addAttribute("title","Add Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("categories", categoryDao.findAll());

        return "recipe/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String submitAddRecipeForm(Model model, @Valid @ModelAttribute Recipe recipe,
                                      Errors errors, @RequestParam int categoryId){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Recipe");
            return "recipe/add";
        }

        Category cat = categoryDao.findById(categoryId).orElse(null);
        recipe.setCategory(cat);
        recipeDao.save(recipe);
        return "redirect:";
    }
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("recipes", recipeDao.findAll());
        model.addAttribute("title", "Remove Recipe");
        return "recipe/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] recipeIds) {

        for (int recipeId : recipeIds) {
            recipeDao.deleteById(recipeId);
        }

        return "redirect:";
    }
}
