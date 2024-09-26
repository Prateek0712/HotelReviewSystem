package com.hotelReviewSystem.userService.userService.RqstDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SaveUserRqst {

    private String name;
    private String email;
    private String about;
}
