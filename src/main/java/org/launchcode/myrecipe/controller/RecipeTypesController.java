package org.launchcode.myrecipe.controller;

import org.launchcode.myrecipe.models.Recipe;
import org.launchcode.myrecipe.models.RecipeTypes;
import org.launchcode.myrecipe.models.data.RecipeDao;
import org.launchcode.myrecipe.models.data.RecipeTypesDao;
import org.launchcode.myrecipe.models.forms.AddRecipeTypesForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("type")
public class RecipeTypesController {

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private RecipeTypesDao recipeTypesDao;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("title","Recipe Types");
        model.addAttribute("recipeTypes", recipeTypesDao.findAll());
        return "recipeTypes/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddRecipeTypesForm(Model model) {
        model.addAttribute("title",
                "Please enter a Recipe type(Breakfast, Lunch/Dinner, Snacks or Drinks)");
        model.addAttribute(new RecipeTypes());

        return "recipeTypes/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String submitRecipeTypeForm(@ModelAttribute @Valid RecipeTypes recipeTypes, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title",
                    "Please enter a Recipe type(Breakfast, Lunch/Dinner, Snacks or Drinks)");
            return "recipeTypes/add";
        }

        recipeTypesDao.save(recipeTypes);
        return "redirect:view/" + recipeTypes.getId();
    }

   @RequestMapping(value = "view/{recipeTypesId}", method = RequestMethod.GET)
    public String viewRecipeTypes(@PathVariable int recipeTypesId, Model model) {

        RecipeTypes selectType = recipeTypesDao.findOne(recipeTypesId);

        model.addAttribute("title", selectType.getName());
        model.addAttribute("recipes", selectType.getRecipes());
        model.addAttribute("recipeTypesId", selectType.getId());

        return "recipeTypes/view";
    }

    @RequestMapping(value = "add-item/{recipeTypesId}", method = RequestMethod.GET)
    public String addItem(@PathVariable int recipeTypesId, Model model) {

        RecipeTypes selectType = recipeTypesDao.findOne(recipeTypesId);

        AddRecipeTypesForm form = new AddRecipeTypesForm(selectType, recipeDao.findAll());
        model.addAttribute("title", "Add recipe to Recipe Type" + selectType.getName());
        model.addAttribute("form", form);

        return "recipeTypes/add-type";
    }

    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    public String AddItem(Model model, @ModelAttribute @Valid AddRecipeTypesForm form, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", form);
            return "recipeTypes/add-item";
        }

        Recipe myRecipe = recipeDao.findOne(form.getRecipeId());
        RecipeTypes myRecipeType = recipeTypesDao.findOne(form.getRecipeTypesId());
        myRecipeType.addItem(myRecipe);
        recipeTypesDao.save(myRecipeType);

        return "redirect:/recipeTypes/view/" + myRecipeType.getId();
    }
}
