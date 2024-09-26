package com.hotelReviewSystem.hotelService.hotelService.Exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException()
    {
        super("Resource not found");
    }

    public ResourceNotFoundException(String  msg)
    {
        super(msg);
    }
}
