package org.example.students.controller;

import org.example.students.entity.SEntity;
import org.example.students.service.SService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SCon {

    @Autowired
    private SService ser;

    @GetMapping("/getAll")
    public List<SEntity> get()
    {
        return ser.getAll();
    }

    @PostMapping("/add")
    public SEntity add(@RequestBody SEntity s)
    {
        return ser.storeData(s);
    }

    @GetMapping("/roll/{roll}")
    public SEntity getEle(@PathVariable int roll){
        return ser.getRoll(roll);
    }
}
