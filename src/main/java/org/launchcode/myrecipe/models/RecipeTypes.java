package org.launchcode.myrecipe.models;

import org.launchcode.myrecipe.models.data.CategoryDao;
import org.launchcode.myrecipe.models.data.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecipeTypes {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @OneToMany
    @JoinColumn(name = "recipe_types_id")
    private List<Recipe> recipes = new ArrayList<>();

    @ManyToOne
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RecipeTypes(String name){
        this.name = name;
    }

    public RecipeTypes(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addItem(Recipe item) {
        recipes.add(item);
    }
}

