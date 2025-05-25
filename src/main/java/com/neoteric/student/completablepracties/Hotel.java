package com.neoteric.student.completablepracties;

public class Hotel {

        private float latitude;
        private float longitude;
        private String hotelName;

        public Hotel(float latitude, float longitude, String hotelName) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.hotelName = hotelName;
        }

        public float getLatitude() {
            return latitude;
        }

        public float getLongitude() {
            return longitude;
        }

        public String getHotelName() {
            return hotelName;
        }
    }

