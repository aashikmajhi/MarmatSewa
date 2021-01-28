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
    private boolean controlsAndBrakes;
    private boolean electricity;
    private boolean puncture;
    private boolean wheelAndControl;
    private String status;
    private TtsSpan.DecimalBuilder latitude;
    private TtsSpan.DecimalBuilder longitude;
    private String vehicleType;



    public Workshop(String businessName, String ownerName, String email, String password, String address, String contactNo, String registrationType, String panNo, String registrationDoc, boolean controlsAndBrakes, boolean electricity, boolean puncture, boolean wheelAndControl, String status, TtsSpan.DecimalBuilder latitude, TtsSpan.DecimalBuilder longitude, String vehicleType) {

        this.businessName = businessName;
        this.ownerName = ownerName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contactNo = contactNo;
        this.registrationType = registrationType;
        this.panNo = panNo;
        this.registrationDoc = registrationDoc;
        this.controlsAndBrakes = controlsAndBrakes;
        this.electricity = electricity;
        this.puncture = puncture;
        this.wheelAndControl = wheelAndControl;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        this.vehicleType = vehicleType;
    }

    public Workshop(String businessName, String ownerName, String email, String password, String address, String contactNo, String registrationType, String panNo, String registrationDoc, boolean controlsAndBrakes, boolean electricity, boolean puncture, boolean wheelAndControl, String status, String vehicleType) {
        this.businessName = businessName;
        this.ownerName = ownerName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contactNo = contactNo;
        this.registrationType = registrationType;
        this.panNo = panNo;
        this.registrationDoc = registrationDoc;
        this.controlsAndBrakes = controlsAndBrakes;
        this.electricity = electricity;
        this.puncture = puncture;
        this.wheelAndControl = wheelAndControl;
        this.status = status;
        this.vehicleType = vehicleType;
    }

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

    public boolean isControlsAndBrakes() {
        return controlsAndBrakes;
    }

    public void setControlsAndBrakes(boolean controlsAndBrakes) {
        this.controlsAndBrakes = controlsAndBrakes;
    }

    public boolean isElectricity() {
        return electricity;
    }

    public void setElectricity(boolean electricity) {
        this.electricity = electricity;
    }

    public boolean isPuncture() {
        return puncture;
    }

    public void setPuncture(boolean puncture) {
        this.puncture = puncture;
    }

    public boolean isWheelAndControl() {
        return wheelAndControl;
    }

    public void setWheelAndControl(boolean wheelAndControl) {
        this.wheelAndControl = wheelAndControl;
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

    public TtsSpan.DecimalBuilder getLatitude() {
        return latitude;
    }

    public void setLatitude(TtsSpan.DecimalBuilder latitude) {
        this.latitude = latitude;
    }

    public TtsSpan.DecimalBuilder getLongitude() {
        return longitude;
    }

    public void setLongitude(TtsSpan.DecimalBuilder longitude) {
        this.longitude = longitude;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
