package com.neoteric.student.completablepracties;

import java.util.concurrent.CompletableFuture;

public class HotelServiceAsync {
    public CompletableFuture<Hotel> getHotelByName(String name) {
        return CompletableFuture.supplyAsync(() -> new Hotel(1.0f, 1.0f, name));
    }
}