package com.lista.listagem;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String senha;

    public User(int id, String firstName, String lastName, String email, String senha){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
