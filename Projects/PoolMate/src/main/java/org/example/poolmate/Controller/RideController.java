package org.example.poolmate.Controller;

import org.example.poolmate.Entity.RideEntity;
import org.example.poolmate.Service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RideController {

    @Autowired
    private RideService ser;

    @PostMapping("/offerRide")
    public RideEntity offerRide(@RequestBody RideEntity ride)
    {
        return ser.offerRide(ride);
    }

    @GetMapping("/getAllRides")
    public List<RideEntity> getAllRides()
    {
        return ser.getAllRides();
    }

    @GetMapping("/getRidesByDriver/{driverId}")
    public List<RideEntity> getRidesByDriver(@PathVariable Long driverId)
    {
        return ser.getRidesByDriver(driverId);
    }

    @PutMapping("/editRide")
    public String editRide(@RequestBody RideEntity ride)
    {
        return ser.editRide(ride);
    }

    @DeleteMapping("/deleteRide/{id}")
    public String deleteRide(@PathVariable Long id)
    {
        return ser.deleteRide(id);
    }
}
