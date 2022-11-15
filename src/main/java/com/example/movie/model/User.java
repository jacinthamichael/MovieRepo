package com.example.movie.model;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Column(name = "title")
    private String name;
    @Column(name = "title")
    private int phoneNumber;
    @Column(name = "userType")
    private String userType;
    @Column(name = "address")
    private String address;
    @Id
    private String userId;

    @Column(name = "password")
    private String password;

    public User(String name, int phoneNumber, String userType, String address, String userId, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.address = address;
        this.userId = userId;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", userType='" + userType + '\'' +
                ", address='" + address + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
