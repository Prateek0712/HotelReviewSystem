package com.hotelReviewSystem.userService.userService.Service;

import com.hotelReviewSystem.userService.userService.Exceptions.ResourceNotFoundException;
import com.hotelReviewSystem.userService.userService.Repository.UserRepository;
import com.hotelReviewSystem.userService.userService.RqstDTO.SaveUserRqst;
import com.hotelReviewSystem.userService.userService.entities.Hotel;
import com.hotelReviewSystem.userService.userService.entities.Rating;
import com.hotelReviewSystem.userService.userService.entities.User;

import com.hotelReviewSystem.userService.userService.externalFeignClientService.HotelFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelFeignService hotelFeignService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public User saveUser(SaveUserRqst user) {
        User user1 = User.builder()
                .userId(UUID.randomUUID().toString())
                .name(user.getName())
                .email(user.getEmail())
                .about(user.getAbout())
                .build();
        user1= userRepository.save(user1);
        return user1;
    }

    @Override
    public List<User> getAllUser() {
        List<User>users=userRepository.findAll();
        return users;
    }

    @Override
    public User getUser(String id) {

        User user= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Sorry Resource is not found"));
        //now will asked rating service to give rating which are bound to this user id
        //List<Rating> ratingList= restTemplate.getForObject();

        //Rating[] ratings= restTemplate.getForObject("http://localhost:8082/ratings/user/"+id, Rating[].class);
        // when we  use @loadBalanced annotation then localhost:port_number is replace by
        // there application name like here url be like (http://RATING-SERVIECE/ratings/user/"+id)
        Rating[] ratings= restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+id, Rating[].class);

        //upper code line will call that url and get  responce here only
        //now each rating object  will have hotel object so do a for loop on ratings and get the hotel object
        for(Rating r:ratings)
        {
            String hotelId=r.getHotelId();
            /*USING RESTTEMPLATE
            ResponseEntity<Hotel> response=restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+hotelId,Hotel.class);
            Hotel hotel=response.getBody();*/

            /*USING FEIGN CLIENT*/
            Hotel hotel=hotelFeignService.getHotelById(hotelId);
            System.out.println(hotel.getHotelId());
            r.setHotel(hotel);
        }
        user.setRatingList(Arrays.stream(ratings).toList());
        return user;
    }



    @Override
    public User deleteUser(String id) {
        return null;
    }

    @Override
    public User updateUser(SaveUserRqst user) {
        return null;
    }
}
