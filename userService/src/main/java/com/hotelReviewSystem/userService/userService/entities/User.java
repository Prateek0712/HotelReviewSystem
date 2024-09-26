package com.hotelReviewSystem.userService.userService.entities;

import jakarta.persistence.*;
import jakarta.transaction.TransactionScoped;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    private String userId;

    private String name;

    private String email;

    private String about;

    @Transient //that  means this will not  be save in the database
    private List<Rating> ratingList=new ArrayList<>();


}
