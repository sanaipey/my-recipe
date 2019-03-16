package org.launchcode.myrecipe.models;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

   // private String youTube;
    @Enumerated(EnumType.STRING)
    private RecipeType recipeType;

    public Recipe(){ }

    @ManyToOne
    private Category category;

    public Recipe(String name, String description, RecipeType recipeType){
        this.name = name;
        this.description  = description;
        this.recipeType = recipeType;

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

    public RecipeType getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(RecipeType recipeType) {
        this.recipeType = recipeType;
    }
    /* public String getYouTube() {
        return youTube;
    }

    public void setYouTube(String youTube) {
        this.youTube = youTube;
    }*/
}
