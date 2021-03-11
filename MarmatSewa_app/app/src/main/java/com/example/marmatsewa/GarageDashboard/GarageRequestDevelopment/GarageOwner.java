package com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment;

public class GarageOwner {
    private String _id;
    private String businessName;
    private String ownerName;
    private String email;
    private String address;
    private String contactNo;
    private String registrationType;

    public GarageOwner(String _id, String businessName, String ownerName, String email, String address, String contactNo, String registrationType) {
        this._id = _id;
        this.businessName = businessName;
        this.ownerName = ownerName;
        this.email = email;
        this.address = address;
        this.contactNo = contactNo;
        this.registrationType = registrationType;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
}
