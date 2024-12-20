package com.example.demo.model;

public class User {
    private Long id;



    private String name; // name
    private String surname; // surname
    private String email; // email
    private int age;






    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public User(long id, String name, String surname, String email) {
    }

    public User() {

    }

    // Getters and Setters

    public long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}