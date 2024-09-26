package com.hotelReviewSystem.hotelService.hotelService.Controller;

import com.hotelReviewSystem.hotelService.hotelService.Entity.Hotel;
import com.hotelReviewSystem.hotelService.hotelService.RqstDTO.hotelDto;
import com.hotelReviewSystem.hotelService.hotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasAuthority;

@RestController
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/")
    public ResponseEntity create (@RequestBody hotelDto hotelDto)
    {
        Hotel hotel =hotelService.createHotel(hotelDto);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/")
    public ResponseEntity getAll()
    {
        List<Hotel>hotels=hotelService.getAll();
        return new ResponseEntity(hotels, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getById(@PathVariable String hotelId)
    {
        System.out.println("I ran till here fine");
        Hotel hotel=hotelService.getHotelById(hotelId);
        System.out.println(hotel.getHotelId());
        return new ResponseEntity(hotel, HttpStatus.OK);
    }
}
