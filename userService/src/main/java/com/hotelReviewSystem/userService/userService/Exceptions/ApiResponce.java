package com.hotelReviewSystem.userService.userService.Exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponce {
    private String message;
    private boolean success;
    private HttpStatus status;
}
