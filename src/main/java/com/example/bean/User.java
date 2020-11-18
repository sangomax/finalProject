package com.example.bean;

public class User {

    private String name;
    private String occupation;

    public User() {

        System.out.println("teste teste");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}