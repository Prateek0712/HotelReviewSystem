package com.hotelReviewSystem.ratingService.ratingService.Service;

import com.hotelReviewSystem.ratingService.ratingService.Entity.Rating;
import com.hotelReviewSystem.ratingService.ratingService.Repository.RatingRepository;
import com.hotelReviewSystem.ratingService.ratingService.RqstDto.RatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating create(RatingDto ratingDto) {
        Rating rating=Rating.builder()
                .ratingId(UUID.randomUUID().toString())
                .userId(ratingDto.getUserId())
                .hotelId(ratingDto.getHotelId())
                .hotelRating(ratingDto.getRating())
                .feedback(ratingDto.getFeedback())
                .build();

        rating=ratingRepository.save(rating);
        return rating;
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return ratingRepository.getAllRatingsByUserId(userId);
        //return new ArrayList<>();
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        return ratingRepository.getAllRatingsByHotelId(hotelId);
        //return new ArrayList<>();
    }
}
