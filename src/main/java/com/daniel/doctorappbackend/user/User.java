package com.daniel.doctorappbackend.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "uzytkownicy")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userId;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "haslo")
    private String userPassword;

    @Column(name = "rola")
    private String userRole;

    public User() {
        userId = 0L;
        userEmail = "";
        userPassword = "";
        userRole = "";
    }

    public User(long userId, String userEmail, String userPassword, String userRole) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public User(String userEmail, String userPassword, String userRole) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return  "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole='" + userRole + '\'';
    }
}

