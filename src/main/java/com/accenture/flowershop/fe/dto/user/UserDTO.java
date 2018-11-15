package com.accenture.flowershop.fe.dto.user;

import com.accenture.flowershop.fe.dto.customer.CustomerDTO;
import com.accenture.flowershop.fe.enums.user.UserRole;

import java.util.Date;

public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private UserRole role;
    private Date createdAt;
    private Date updatedAt;
    private CustomerDTO customer;

    public UserDTO() {
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO(long id, String username, String password, String confirmPassword, String email, UserRole role, Date createdAt, Date updatedAt, CustomerDTO customer) {
        this(username, password);
        this.id = id;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.customer = customer;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
