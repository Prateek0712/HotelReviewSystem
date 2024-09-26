package com.hotelReviewSystem.ratingService.ratingService.Controller;


import com.hotelReviewSystem.ratingService.ratingService.Entity.Rating;
import com.hotelReviewSystem.ratingService.ratingService.RqstDto.RatingDto;
import com.hotelReviewSystem.ratingService.ratingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {


    @Autowired
    private RatingService ratingService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/")
    public ResponseEntity creating(@RequestBody RatingDto ratingDto)
    {
        Rating rating=ratingService.create(ratingDto);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllRating()
    {
        List<Rating> ratings=ratingService.getAllRating();

        return new ResponseEntity(ratings, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/user/{userId}")
    public ResponseEntity getAllRatingByUserId(@PathVariable String userId)
    {
        List<Rating> ratings=ratingService.getAllRatingByUserId(userId);
        return new ResponseEntity(ratings, HttpStatus.OK);
    }


    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity  getAllRatingByHotelId(@PathVariable String hotelId)
    {
        List<Rating> ratings=ratingService.getAllRatingByHotelId(hotelId);
        return new ResponseEntity(ratings,HttpStatus.FOUND);
    }

}
