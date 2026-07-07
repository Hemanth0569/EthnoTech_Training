package org.example.students.repo;

import org.example.students.entity.SEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SRepo extends JpaRepository<SEntity,Integer> {

    public SEntity findByRoll(int roll);
}
