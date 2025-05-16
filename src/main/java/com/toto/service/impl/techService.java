package com.toto.service.impl;

import com.toto.entity.Technician;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface techService {
    List<Technician> getTechs();
    void addTech(Technician technician);
    void deleteTech(Technician technician);
    void increaseRebootCount(Technician technician);
}
