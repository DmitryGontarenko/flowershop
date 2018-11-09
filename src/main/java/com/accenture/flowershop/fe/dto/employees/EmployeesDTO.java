package com.accenture.flowershop.fe.dto.employees;

public class EmployeesDTO {

    private long id;
    private String username;
    private String password;

    public EmployeesDTO() {
    }

    public EmployeesDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public EmployeesDTO(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
