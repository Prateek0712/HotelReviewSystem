package com.hotelReviewSystem.hotelService.hotelService.Repository;

import com.hotelReviewSystem.hotelService.hotelService.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
}
