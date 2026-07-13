package org.example.poolmate.Service;

import org.example.poolmate.Entity.RideEntity;
import org.example.poolmate.Repository.RideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    @Autowired
    private RideRepo repo;

    public RideEntity offerRide(RideEntity ride)
    {
        ride.setAvailableSeats(ride.getTotalSeats());
        return repo.save(ride);
    }

    public List<RideEntity> getAllRides()
    {
        return repo.findAll();
    }

    public List<RideEntity> getRidesByDriver(Long driverId)
    {
        return repo.findByDriverId(driverId);
    }

    public String editRide(RideEntity ride)
    {
        RideEntity existing=repo.findById(ride.getId()).orElse(null);
        if(existing==null){
            return "Ride Not Found";
        }
        existing.setSource(ride.getSource());
        existing.setDestination(ride.getDestination());
        existing.setRideDate(ride.getRideDate());
        existing.setRideTime(ride.getRideTime());
        existing.setTotalSeats(ride.getTotalSeats());
        existing.setAvailableSeats(ride.getAvailableSeats());

        repo.save(existing);
        return "Ride Updated Successfully";
    }

    public String deleteRide(Long id)
    {
        repo.deleteById(id);
        return "Ride Deleted Successfully";
    }
}
