package com.koray.studentmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = "First name can not be empty")
    @Size(min = 4,max = 50, message = "First name length should be between 4 and 50 characters")
    private String firstName;
    @NotEmpty(message = "Last name can not be empty")
    @Column(name = "last_name")
    @Size(min = 4,max = 50, message = "Last name length should be between 4 and 50 characters")
    private String lastName;
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Not valid email format")
    @Column(name = "email")
    private String email;

    public Student(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
