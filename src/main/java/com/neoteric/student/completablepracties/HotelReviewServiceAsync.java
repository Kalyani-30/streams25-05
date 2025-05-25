//package com.neoteric.student.completablepracties;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//public class HotelReviewServiceAsync {
//    public CompletableFuture<List<Review>> getHotelReviews(int locationId, String name) {
//        return CompletableFuture.supplyAsync(() -> {
//            List<Review> reviews = new ArrayList<>();
//            reviews.add(new Review(5, "Excellent Stay", locationId, 101, name));
//            return reviews;
//        });
//    }
//
//    public CompletableFuture<List<Image>> getHotelImages(int locationId, String name) {
//        return CompletableFuture.supplyAsync(() -> {
//            List<Image> images = new ArrayList<>();
//            images.add(new Image(1, "https://example.com/image.jpg", locationId, name));
//            return images;
//        });
//    }
//}