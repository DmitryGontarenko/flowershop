package com.accenture.flowershop.be.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES", schema = "PUBLIC", catalog = "FLOWERSHOPDS")
public class EmployeesEntity {

    private Long id;
    private String name;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
