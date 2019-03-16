package org.launchcode.myrecipe.models;

import org.launchcode.myrecipe.models.data.CategoryDao;
import org.launchcode.myrecipe.models.data.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class RecipeTypes {
    @Autowired
    RecipeDao recipeDao;

    @Autowired
    CategoryDao categoryDao;


    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public RecipeTypes(){}




}

