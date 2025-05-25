package com.neoteric.student.threadpracties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/hotel")
public class BookingHotelController {

    @Autowired
   BookingHotelRepo bookingHotelRepo;

    private ExecutorService executorService= Executors.newFixedThreadPool(3);

@PostMapping("/booking")
    public BookingEntity roomBooking(@RequestBody BookingEntity bookingEntity)throws ExecutionException,InterruptedException {

        BookingHotelService service= new BookingHotelService(bookingHotelRepo,
                bookingEntity.getCustomerName(),
                bookingEntity.getRoomNo(),
                bookingEntity.getMsg(),
                bookingEntity.getBookingId()
        );

        Future<BookingEntity> future= executorService.submit(service);
        return future.get();
    }
@GetMapping("/all")
    public List<BookingEntity>getallbookings(){
    return bookingHotelRepo.findAll();
    }
}
