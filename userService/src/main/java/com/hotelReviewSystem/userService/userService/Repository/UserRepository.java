package com.hotelReviewSystem.userService.userService.Repository;

import com.hotelReviewSystem.userService.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
