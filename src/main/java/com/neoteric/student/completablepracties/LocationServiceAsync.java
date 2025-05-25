package com.neoteric.student.completablepracties;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LocationServiceAsync {
    public CompletableFuture<List<Location>> getLocationsByLatLong(float latitude, float longitude) {
        return CompletableFuture.supplyAsync(() -> {
            List<Location> locations = new ArrayList<>();
            locations.add(new Location(101, "Neoteric", latitude, longitude));
            return locations;
        });
    }
}