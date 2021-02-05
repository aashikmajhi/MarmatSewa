package com.example.marmatsewa.Registration.UserRegistrationDevelopment;

public class User {

    private String _id;
    private String fullname;
    private String email;
    private String password;
    private String phoneNo;
    private String address;
    private String dob;
    private String gender;
    private String scannedLicense;

    public User(String fullname, String email, String password, String phoneNo, String address, String dob, String gender, String scannedLicense) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.scannedLicense = scannedLicense;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getScannedLicense() {
        return scannedLicense;
    }

    public void setScannedLicense(String scannedLicense) {
        this.scannedLicense = scannedLicense;
    }
}

