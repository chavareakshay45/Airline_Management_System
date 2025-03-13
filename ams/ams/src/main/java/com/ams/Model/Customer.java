package com.ams.Model;

import java.sql.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "customers")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserID;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(nullable = false)
    private String Password;

    @Column(name = "role", nullable = false)
    private String Role; // (Check Constraint: Admin / Customer)

    @Column(name = "customer_category")
    private String CustomerCategory; // Removed @NotNull, assuming it can be null

    @Column(nullable = false, unique = true)
    private String Phone;

    @Column(name = "email_id", nullable = true , unique = true)
    private String EmailId;

    private String Address1;
    private String Address2;
    private String City;
    private String State;
    private String Country;

    @Column(name = "zip_code")
    private String ZipCode;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date DOB;

    // Default constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(Long userID, String userName, String password, String role, String customerCategory, String phone,
            String emailId, String address1, String address2, String city, 
            String state, String country, String zipCode,
            Date dOB) {
        this.UserID = userID;
        this.userName = userName;
        this.Password = password;
        this.Role = role;
        this.CustomerCategory = customerCategory;
        this.Phone = phone;
        this.EmailId = emailId;
        this.Address1 = address1;
        this.Address2 = address2;
        this.City = city;
        this.State = state;
        this.Country = country;
        this.ZipCode = zipCode;
        this.DOB = dOB;
    }

    // Getters and Setters
    public Long getUserID() {
        return UserID;
    }
    public void setUserID(Long userID) {
        UserID = userID;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getRole() {
        return Role;
    }
    public void setRole(String role) {
        Role = role;
    }
    public String getCustomerCategory() {
        return CustomerCategory;
    }
    public void setCustomerCategory(String customerCategory) {
        CustomerCategory = customerCategory;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getEmailId() {
        return EmailId;
    }
    public void setEmailId(String emailId) {
        EmailId = emailId;
    }
    public String getAddress1() {
        return Address1;
    }
    public void setAddress1(String address1) {
        Address1 = address1;
    }
    public String getAddress2() {
        return Address2;
    }
    public void setAddress2(String address2) {
        Address2 = address2;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
    public String getState() {
        return State;
    }
    public void setState(String state) {
        State = state;
    }
    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        Country = country;
    }
    public String getZipCode() {
        return ZipCode;
    }
    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }
    public Date getDOB() {
        return DOB;
    }
    public void setDOB(Date dOB) {
        DOB = dOB;
    }

    // Optional: Override toString method for easy logging
    @Override
    public String toString() {
        return "Customer [UserID=" + UserID + ", UserName=" + userName + ", Password=" + Password + ", Role=" + Role
                + ", CustomerCategory=" + CustomerCategory + ", Phone=" + Phone + ", EmailId=" + EmailId
                + ", Address1=" + Address1 + ", Address2=" + Address2 + ", City=" + City + ", State=" + State
                + ", Country=" + Country + ", ZipCode=" + ZipCode + ", DOB=" + DOB + "]";
    }
}
