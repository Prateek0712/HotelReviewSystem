package com.hotelReviewSystem.userService.userService.Service;

import com.hotelReviewSystem.userService.userService.RqstDTO.SaveUserRqst;
import com.hotelReviewSystem.userService.userService.entities.User;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {

    User saveUser(SaveUserRqst user);

    List<User> getAllUser();

    User getUser(String id);

    User deleteUser(String id);

    User updateUser(SaveUserRqst user);
}
