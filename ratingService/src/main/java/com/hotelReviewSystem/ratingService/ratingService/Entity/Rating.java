package com.hotelReviewSystem.ratingService.ratingService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

@Entity
@Table(name = "rating")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Rating {

    @Id
    private String ratingId;

    private String userId;

    private String hotelId;

    private int hotelRating;

    private String feedback;

    //there might be hotel obj here
    /*@Transient
    private Hotel hotel=null;*/
}
