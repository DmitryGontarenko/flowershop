package com.accenture.flowershop.be.entity.employees;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findEmployeesById", query = "select c from EmployeesEntity c where c.name = :n")
@Table(name = "EMPLOYEES", schema = "PUBLIC", catalog = "FLOWERSHOPDS")
public class EmployeesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PASSWORD")
    private String password;


    public Long getId() {
        return id;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
