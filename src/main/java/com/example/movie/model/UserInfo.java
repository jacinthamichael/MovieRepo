package com.example.movie.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "UserInfo")
@Getter
@Setter
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "phoneNumber")
    private int phoneNumber;
    @Column(name = "userType")
    private String userType;
    @Column(name = "address")
    private String address;


    @Column(name = "password")
    private String password;

    public UserInfo(String name, int phoneNumber, String userType, String address, Long id, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.address = address;
        this.id = id;
        this.password = password;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(int phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getUserType() {
//        return userType;
//    }
//
//    public void setUserType(String userType) {
//        this.userType = userType;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long userId) {
//        this.id = id;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", phoneNumber=" + phoneNumber +
//                ", userType='" + userType + '\'' +
//                ", address='" + address + '\'' +
//                ", id='" + id + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
