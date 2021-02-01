package com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment;

public class User {
    private String fullname;
    private String phoneNo;
    private String address;

    public User(String fullname, String phoneNo, String address) {
        this.fullname = fullname;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

