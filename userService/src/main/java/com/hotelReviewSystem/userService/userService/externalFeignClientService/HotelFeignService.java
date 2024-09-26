package com.hotelReviewSystem.userService.userService.externalFeignClientService;

import com.hotelReviewSystem.userService.userService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@Service
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelFeignService {


    //IT will be  declarative approach jst declare the method same as we delcare in controller class of hotel service

    @GetMapping(value = "/hotel/{hotelId}")
    public Hotel getHotelById(@PathVariable String hotelId);



    //like this we can create put, post, del also
   /* @PostMapping("/hotel")
    public Hotel createHotel(@R)*/


}
