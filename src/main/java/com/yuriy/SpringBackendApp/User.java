package com.yuriy.SpringBackendApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TABLE") // cannot just name table "user" because it is a keyword
public class User {
    private @GeneratedValue @Id Integer id;

    private String email;
    private String firstName;
    private String surName;

    public User() {

    }

    public User(String email, String firstName, String surName) {
        this.email = email;
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
