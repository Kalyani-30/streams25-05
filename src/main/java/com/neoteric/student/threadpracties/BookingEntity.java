package com.neoteric.student.threadpracties;

import jakarta.persistence.*;

@Entity
@Table(name = "bookinghotel")

public class BookingEntity {
    @Id
    private String customerName;
    private  int roomNo;
    private  String msg;
    private int bookingId;

    public BookingEntity() {}

    public BookingEntity(String customerName, int roomNo, String msg, int bookingId) {
        this.customerName = customerName;
        this.roomNo = roomNo;
        this.msg = msg;
        this.bookingId = bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
