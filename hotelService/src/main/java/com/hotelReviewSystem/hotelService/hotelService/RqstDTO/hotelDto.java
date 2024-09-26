package com.hotelReviewSystem.hotelService.hotelService.RqstDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class hotelDto {

    private String name;
    private String location;
    private String about;
}
