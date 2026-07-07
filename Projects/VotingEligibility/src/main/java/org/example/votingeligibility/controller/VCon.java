package org.example.votingeligibility.controller;

import org.example.votingeligibility.entity.VEntity;
import org.example.votingeligibility.service.VService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VCon {
    @Autowired
    private VService ser;

    @PostMapping("/add")
    public VEntity add(@RequestBody VEntity v)
    {
        return ser.storeData(v);
    }

    @GetMapping("/getAll")
    public List<VEntity> get()
    {
        return ser.getAll();
    }

    @GetMapping("/getEle")
    public List<VEntity> getEle()
    {
        return ser.getByEle(true);
    }
}
