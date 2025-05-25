package com.neoteric.student.threadpracties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;


public class BookingHotelService implements Callable<BookingEntity> {
private BookingHotelRepo bookingHotelRepo;
    private String customerName;
    private int roomNO;
    private  String msg;
    private int bookingId;

    public BookingHotelService(BookingHotelRepo bookingHotelRepo,String customerName, int roomNo, String msg, int bookingId){
        this.bookingHotelRepo=bookingHotelRepo;
        this.customerName=customerName;
        this.roomNO=roomNo;
        this.msg = msg;
        this.bookingId = bookingId;

    }

    @Override
    public BookingEntity call() throws Exception {
    BookingEntity entity= new BookingEntity(customerName,roomNO,msg,bookingId);
    return bookingHotelRepo.save(entity);
    }
}


