package org.launchcode.myrecipe.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id//id should be a primary key and unique  in DB
    @GeneratedValue//Hibernate(Data layer)should generate that value for us
    private int id;

    @Size(min=3, max=15)
    private String userName;

    @NotNull
    @Size(min=3, max=30)
    private String email;

    @NotNull
    @Size(min=3, max=10)
    private String password;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Recipe> recipe;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Category> category;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<RecipeTypes> recipeTypes;

    //private int userId;
    //private static int nextId = 1;  //initializes userId so that it's unique for every single user object

    public User() {
    }

    public User(String userName, String email, String password){
        //this(); //calls default constructor for the User class and initializes Id field
        this.userName = userName;
        this.email = email;
        this.password = password;

    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Recipe> getRecipe() { return recipe; }

    public List<Category> getCategory() { return category; }

    public List<RecipeTypes> getRecipeTypes() { return recipeTypes; }
}
