package com.neoteric.student.completablepracties;

public class Location {
    private int locationId;
    private String name;
    private float latitude;
    private float longitude;

    public Location(int locationId, String name, float latitude, float longitude) {
        this.locationId = locationId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getName() {
        return name;
    }
}