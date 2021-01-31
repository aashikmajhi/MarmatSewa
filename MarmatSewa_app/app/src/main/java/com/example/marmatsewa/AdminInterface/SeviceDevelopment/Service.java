package com.example.marmatsewa.AdminInterface.SeviceDevelopment;

public class Service {
    private String feature;
    private String admin_id;

    public Service(String feature, String admin_id) {
        this.feature = feature;
        this.admin_id = admin_id;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
}
