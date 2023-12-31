package com.rodriguezlazo.tasksmanager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewUserDTO {
    @NotBlank
    @Size(min = 3)
    private String name;
    @NotBlank
    @Size(min = 4)
    private String lastname;
    @NotBlank
    @Size(min = 4)
    private String username;
    @NotBlank()
    @Size(min = 4)
    private String password;

    public NewUserDTO() {
    }

    public NewUserDTO(String name, String lastname, String username, String password) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
