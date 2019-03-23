package org.launchcode.myrecipe.models.forms;

import org.launchcode.myrecipe.models.Recipe;
import org.launchcode.myrecipe.models.RecipeTypes;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public class AddRecipeTypesForm {

    @NotNull
    private int recipeId;

    @NotNull
    private int recipeTypesId;

    private RecipeTypes recipeTypes;

    private Iterable<Recipe> recipes;

    public AddRecipeTypesForm(RecipeTypes recipeTypes, Iterable<Recipe> recipes){
        this.recipeTypes = recipeTypes;
        this.recipes = recipes;
    }

    public AddRecipeTypesForm(Optional<RecipeTypes> selectType, Iterable<Recipe> all){}

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getRecipeTypesId() {
        return recipeTypesId;
    }

    public void setRecipeTypesId(int recipeTypesId) {
        this.recipeTypesId = recipeTypesId;
    }

    public RecipeTypes getRecipeTypes() {
        return recipeTypes;
    }

    public void setRecipeTypes(RecipeTypes recipeTypes) {
        this.recipeTypes = recipeTypes;
    }

    public Iterable<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Iterable<Recipe> recipes) {
        this.recipes = recipes;
    }
}
