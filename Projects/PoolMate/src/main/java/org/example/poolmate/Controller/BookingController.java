package org.example.poolmate.Controller;

import org.example.poolmate.Entity.BookingEntity;
import org.example.poolmate.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService ser;

    @PostMapping("/joinRide")
    public String joinRide(@RequestBody BookingEntity booking)
    {
        return ser.joinRide(booking);
    }

    @GetMapping("/myRides/{userId}")
    public List<BookingEntity> myRides(@PathVariable Long userId)
    {
        return ser.myRides(userId);
    }

    @DeleteMapping("/cancelBooking/{id}")
    public String cancelBooking(@PathVariable Long id)
    {
        return ser.cancelBooking(id);
    }
}
