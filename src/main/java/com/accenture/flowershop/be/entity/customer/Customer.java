package com.accenture.flowershop.be.entity.customer;

import com.accenture.flowershop.be.entity.user.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_customer")
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
        @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id")
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "balance", precision = 8, scale = 2)
    private BigDecimal balance;

    @Column(name = "discount")
    private int discount;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Customer() {
    }

    public Customer(String firstName, String lastName, BigDecimal balance, int discount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.discount = discount;
    }

    public Customer(String firstName, String lastName, BigDecimal balance, int discount, String phoneNumber, String street, String city, String country, User user) {
        this(firstName, lastName, balance, discount);
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.country = country;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                ", discount=" + discount +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", user=" + user +
                '}';
    }
}
