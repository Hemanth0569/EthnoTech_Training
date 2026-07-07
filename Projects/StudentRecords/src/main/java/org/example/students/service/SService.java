package org.example.students.service;

import org.example.students.entity.SEntity;
import org.example.students.repo.SRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SService {

    @Autowired
    private SRepo repo;
    public SEntity storeData(SEntity s)
    {
        if(s.getAge()>0)
        {
            return repo.save(s);
        }
        else return null;
    }

    public List<SEntity> getAll()
    {
        return repo.findAll();
    }

    public SEntity getRoll(int roll){
        return repo.findByRoll(roll);
    }
}
