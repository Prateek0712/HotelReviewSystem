package com.hotelReviewSystem.userService.userService.Controller;

import com.hotelReviewSystem.userService.userService.RqstDTO.SaveUserRqst;
import com.hotelReviewSystem.userService.userService.Service.UserService;
import com.hotelReviewSystem.userService.userService.entities.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/")
    public ResponseEntity saveUser(@RequestBody SaveUserRqst userRqst)
    {
        User u1=userService.saveUser(userRqst);
        return new ResponseEntity(u1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity getAllUser()
    {
        List<User>user=userService.getAllUser();
        return new ResponseEntity(user,HttpStatus.FOUND);
    }

    @GetMapping("/{userId}")
    //@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
    //@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallBack")

    /* Retry and circuit breaker cant  be use together with such configuration becoz circuit breaker breaks
    * the circuit if request fails so there any no way for retry to execute  there might be different way to
    * configure both combinely but as of  not with using simple annotation only it wont be possible here
    * actuator/health  ==for checking health
    *  remember one try you can do by using diff fall back method you didnt tried it till now */

    //@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallBack")
    //@RateLimiter(name="userRateLimiter", fallbackMethod = "ratingHotelFallBack")
    //this rate limiter limit the  number rate that will serve to perticular endpoit to prevent DOS attack and
    // increasing performance
    public ResponseEntity getAUser(@PathVariable String userId)
    {
        User u1=userService.getUser(userId);
        System.out.println(u1.toString());
        return new ResponseEntity(u1,HttpStatus.FOUND);
    }
    //fall back method for retry as well as circuit breaker
    public ResponseEntity ratingHotelFallBack(String userId,Exception ex)
    {
        String str= "Dear user "+userId+" kindly weight for some time system is unable to fetch now...";
        System.out.println(str);
        logger.info(str+" "+ex.getMessage());
        return new ResponseEntity(str,HttpStatus.BAD_REQUEST);
    }
    //
}
