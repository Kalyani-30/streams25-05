package com.neoteric.student.threadpracties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingHotelRepo extends JpaRepository<BookingEntity,Integer> {
}
