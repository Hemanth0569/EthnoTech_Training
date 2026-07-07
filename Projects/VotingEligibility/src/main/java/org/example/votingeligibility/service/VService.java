package org.example.votingeligibility.service;

import org.example.votingeligibility.Repo.VRepo;
import org.example.votingeligibility.entity.VEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VService {

    //VRepo repo = new VRepo() {}

    @Autowired
    private VRepo repo;

    public VEntity storeData(VEntity v)
    {
        if(v.getAge() >= 18)
        {
            v.setEligible(true);
        }
        return repo.save(v);
    }

    public List<VEntity> getAll(){
        return repo.findAll();
    }

    public List<VEntity> getByEle(boolean isEligible)
    {
        return repo.findByIsEligible(isEligible);
    }
}

