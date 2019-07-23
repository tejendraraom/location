package com.example.location;

public class Traffic {
    String lattitude;
    String longitude;


    public Traffic(String lattitude, String longitude) {
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public String getLattitude() {
        return lattitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
