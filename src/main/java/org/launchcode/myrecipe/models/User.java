package org.launchcode.myrecipe.models;


public class User {


    private String userName;
    private String email;
    private String password;
    private int userId;
    private static int nextId = 1;  //initializes userId so that it's unique for every single user object



    public User() {
        userId = nextId;
        nextId++;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public User(String userName, String email, String password){
        this(); //calls default constructor for the User class and initializes Id field
        this.userName = userName;
        this.email = email;
        this.password = password;

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


}
