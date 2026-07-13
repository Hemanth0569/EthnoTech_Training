package org.example.poolmate.Service;

import org.example.poolmate.Entity.BookingEntity;
import org.example.poolmate.Entity.RideEntity;
import org.example.poolmate.Repository.BookingRepo;
import org.example.poolmate.Repository.RideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private RideRepo rideRepo;

    public String joinRide(BookingEntity booking)
    {
        RideEntity ride=rideRepo.findById(booking.getRideId()).orElse(null);
        if(ride==null)
        {
            return "Ride Not Found";
        }

        if(ride.getAvailableSeats()<booking.getSeatsBooked())
        {
            return "Seats Not Available";
        }

        ride.setAvailableSeats(ride.getAvailableSeats()-booking.getSeatsBooked());
        rideRepo.save(ride);
        bookingRepo.save(booking);
        return "Ride Joined Successfully";
    }

    public List<BookingEntity> myRides(Long userId)
    {
        return bookingRepo.findByUserId(userId);
    }

    public String cancelBooking(Long id)
    {
        BookingEntity booking=bookingRepo.findById(id).orElse(null);
        if(booking==null){
            return "Booking Not Found";
        }
        RideEntity ride=rideRepo.findById(booking.getRideId()).orElse(null);
        if(ride!=null)
        {
            ride.setAvailableSeats(ride.getAvailableSeats()+booking.getSeatsBooked());
            rideRepo.save(ride);
        }
        bookingRepo.deleteById(id);
        return "Booking Cancelled Successfully";
    }
}
