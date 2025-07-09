package com.example.core;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;

public class User {
    private int id;

    @NotEmpty
    private String name;

    @Email
    private String email;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
