package org.example.poolmate.Repository;

import org.example.poolmate.Entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<BookingEntity,Long> {
    List<BookingEntity> findByUserId(Long id);
}
