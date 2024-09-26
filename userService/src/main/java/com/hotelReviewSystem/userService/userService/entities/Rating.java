package com.hotelReviewSystem.userService.userService.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Rating {

    private String ratingId;

    private String userId;

    private String hotelId;

    private int hotelRating;

    private String feedback;

    //there might be hotel obj here

    private Hotel hotel;
}
