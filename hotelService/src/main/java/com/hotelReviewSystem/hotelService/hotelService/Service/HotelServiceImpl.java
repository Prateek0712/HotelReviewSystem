package com.hotelReviewSystem.hotelService.hotelService.Service;

import com.hotelReviewSystem.hotelService.hotelService.Entity.Hotel;
import com.hotelReviewSystem.hotelService.hotelService.Exceptions.ResourceNotFoundException;
import com.hotelReviewSystem.hotelService.hotelService.Repository.HotelRepository;
import com.hotelReviewSystem.hotelService.hotelService.RqstDTO.hotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(hotelDto hotelDto) {
        Hotel hotel= Hotel.builder()
                .hotelId(UUID.randomUUID().toString())
                .hotelName(hotelDto.getName())
                .location(hotelDto.getLocation())
                .about(hotelDto.getAbout())
                .build();
        hotel=hotelRepository.save(hotel);
        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given id not found"));
    }
}
