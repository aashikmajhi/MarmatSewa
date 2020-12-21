package com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment;

public class Workshop {

    private String businessName;
    private String ownerName;
    private String email;
    private String password;
    private String address;
    private String contactNo;
    private String registrationType;
    private String panDoc;
    private String registrationDoc;
    private boolean controlsAndBrakes;
    private boolean electricity;
    private boolean puncture;
    private boolean wheelAndControl;

    public Workshop() {
    }

    public Workshop(String businessName, String ownerName, String email, String password, String address, String contactNo, String registrationType, String panDoc, String registrationDoc, boolean controlsAndBrakes, boolean electricity, boolean puncture, boolean wheelAndControl) {
        this.businessName = businessName;
        this.ownerName = ownerName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contactNo = contactNo;
        this.registrationType = registrationType;
        this.panDoc = panDoc;
        this.registrationDoc = registrationDoc;
        this.controlsAndBrakes = controlsAndBrakes;
        this.electricity = electricity;
        this.puncture = puncture;
        this.wheelAndControl = wheelAndControl;
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

    public String getPanDoc() {
        return panDoc;
    }

    public void setPanDoc(String panDoc) {
        this.panDoc = panDoc;
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
}
