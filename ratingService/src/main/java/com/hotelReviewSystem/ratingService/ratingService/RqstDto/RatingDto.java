package com.hotelReviewSystem.ratingService.ratingService.RqstDto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class RatingDto {

    private String userId;

    private String hotelId;

    private int rating;

    private String feedback;
}
