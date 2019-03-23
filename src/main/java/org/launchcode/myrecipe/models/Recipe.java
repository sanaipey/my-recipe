package org.launchcode.myrecipe.models;

import org.launchcode.myrecipe.models.data.RecipeDao;
import org.launchcode.myrecipe.models.data.RecipeTypesDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Recipe {

    @GeneratedValue
    @Id
    private int id;

    @NotNull
    @Size(min=3, max=30)
    private String name;

    @NotNull
    @Size(min=1, message="Description must not be empty")
    private String description;

   // private String youTube

    public Recipe(){ }

    @ManyToOne
    private RecipeTypes recipeTypes;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    public Recipe(String name, String description){
        this.name = name;
        this.description  = description;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public RecipeTypes getRecipeTypes() {
        return recipeTypes;
    }

    public void setRecipeTypes(RecipeTypes recipeTypes) {
        this.recipeTypes = recipeTypes;
    }
}

    /* public String getYouTube() {
        return youTube;
    }

    public void setYouTube(String youTube) {
        this.youTube = youTube;
    }*/

