package com.hotelReviewSystem.ratingService.ratingService.Entity;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Hotel {
    private String hotelId;

    private String hotelName;

    private String location;

    private String about;
}
