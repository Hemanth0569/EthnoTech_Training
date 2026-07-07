package org.example.votingeligibility.Repo;

import org.example.votingeligibility.entity.VEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VRepo extends JpaRepository<VEntity,Integer> {

    public List<VEntity> findByIsEligible(boolean isEligible);

}
