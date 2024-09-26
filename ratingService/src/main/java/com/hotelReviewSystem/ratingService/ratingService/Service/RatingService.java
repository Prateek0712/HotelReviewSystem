package com.hotelReviewSystem.ratingService.ratingService.Service;


import com.hotelReviewSystem.ratingService.ratingService.Entity.Rating;
import com.hotelReviewSystem.ratingService.ratingService.RqstDto.RatingDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingService {


    Rating create(RatingDto ratingDto);

    List<Rating> getAllRating();

    List<Rating> getAllRatingByUserId(String userId);

    List<Rating> getAllRatingByHotelId(String hotelId);

}
