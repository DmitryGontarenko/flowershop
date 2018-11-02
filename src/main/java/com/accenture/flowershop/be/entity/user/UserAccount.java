package com.accenture.flowershop.be.entity.user;

import javax.persistence.*;

//@Entity
//@Table(name = "EMPLOYEES")
public class UserAccount {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
//    @Column(name = "NAME")
    private String name;
//    @Column(name = "PASSWORD")
    private String password;

    public UserAccount() {
    }

    public UserAccount(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
