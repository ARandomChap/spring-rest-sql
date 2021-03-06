package com.demo.springrestsql.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    private UUID id;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}