package org.launchcode.myrecipe.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


public enum RecipeType {



    BREAKFAST ("Breakfast"),

    LUNCHDINNER ("Lunch/Dinner"),

    SNACKS ("Snacks"),

    DRINKS ("Drinks");

    private final String name;

    RecipeType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
