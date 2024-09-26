package com.hotelReviewSystem.hotelService.hotelService.Service;

import com.hotelReviewSystem.hotelService.hotelService.Entity.Hotel;
import com.hotelReviewSystem.hotelService.hotelService.RqstDTO.hotelDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService {

    Hotel createHotel(hotelDto hotelDto);

    List<Hotel>getAll();

    Hotel getHotelById(String id);


}
