package org.example.poolmate.Repository;

import org.example.poolmate.Entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepo extends JpaRepository<RideEntity,Long> {
    List<RideEntity> findByDriverId(Long driverId);
}
