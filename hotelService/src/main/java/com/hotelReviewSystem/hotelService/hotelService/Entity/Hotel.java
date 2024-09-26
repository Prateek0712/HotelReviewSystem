package com.hotelReviewSystem.hotelService.hotelService.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Hotels")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Hotel {

    @Id
    private String hotelId;

    private String hotelName;

    private String location;

    private String about;
}
