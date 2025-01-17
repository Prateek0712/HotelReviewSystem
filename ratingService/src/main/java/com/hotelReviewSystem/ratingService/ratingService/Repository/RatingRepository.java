package com.hotelReviewSystem.ratingService.ratingService.Repository;

import com.hotelReviewSystem.ratingService.ratingService.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

    List<Rating>getAllRatingsByUserId(String userId);

    List<Rating>getAllRatingsByHotelId(String hotelId);
}

