package com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment;

import android.text.style.TtsSpan;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Workshop {

    private String businessName;
    private String ownerName;
    private String email;
    private String password;
    private String address;
    private String contactNo;
    private String registrationType;
    private String panNo;
    private String registrationDoc;
    private String status;
    private String latitude;
    private String longitude;
    private String vehicleType;


    public Workshop(String businessName, String ownerName, String email, String password, String address, String contactNo, String registrationType, String panNo, String registrationDoc, String status, String latitude, String longitude, String vehicleType) {
        this.businessName = businessName;
        this.ownerName = ownerName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contactNo = contactNo;
        this.registrationType = registrationType;
        this.panNo = panNo;
        this.registrationDoc = registrationDoc;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        this.vehicleType = vehicleType;
    }

//    public Workshop(String businessName, String ownerName, String email, String password, String address, String contactNo, String registrationType, String panNo, String registrationDoc, String status, String latitude, String longitude, String vehicleType) {
//        this.businessName = businessName;
//        this.ownerName = ownerName;
//        this.email = email;
//        this.password = password;
//        this.address = address;
//        this.contactNo = contactNo;
//        this.registrationType = registrationType;
//        this.panNo = panNo;
//        this.registrationDoc = registrationDoc;
//        this.status = status;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.vehicleType = vehicleType;
//
//    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public String getpanNo() {
        return panNo;
    }

    public void setpanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getRegistrationDoc() {
        return registrationDoc;
    }

    public void setRegistrationDoc(String registrationDoc) {
        this.registrationDoc = registrationDoc;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
