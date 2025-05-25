//package com.neoteric.student.completablepracties;
//
//import com.neoteric.student.completablepracties.*;
//
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//public class AvootaHotelAppAsync {
//    public static void main(String[] args) {
//       HotelServiceAsync hotelService = new HotelServiceAsync();
//        LocationServiceAsync locationService = new LocationServiceAsync();
//        HotelReviewServiceAsync reviewService = new HotelReviewServiceAsync();
//
//        hotelService.getHotelByName("Neoteric")
//                .thenCompose(hotel -> locationService.getLocationsByLatLong(hotel.getLatitude(), hotel.getLongitude())
//                        .thenCompose(locations -> {
//                            Location hotelLocation = locations.get(0);
//                            CompletableFuture<List<Review>> reviewsFuture = reviewService.getHotelReviews(hotelLocation.getLocationId(), hotelLocation.getName());
//                            CompletableFuture<List<Image>> imagesFuture = reviewService.getHotelImages(hotelLocation.getLocationId(), hotelLocation.getName());
//
//                            return CompletableFuture.allOf(reviewsFuture, imagesFuture)
//                                    .thenRun(() -> {
//                                        List<Review> reviews = reviewsFuture.join();
//                                        List<Image> images = imagesFuture.join();
//                                        System.out.println("Reviews: " + reviews);
//                                        System.out.println("Images: " + images);
//                                    });
//                        }));
//
//        try {
//            Thread.sleep(3000);  // Waiting for async tasks to complete
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}