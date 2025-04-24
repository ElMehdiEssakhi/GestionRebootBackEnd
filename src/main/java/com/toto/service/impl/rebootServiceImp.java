package com.toto.service.impl;

import com.toto.entity.Reb;
import com.toto.entity.User;
import com.toto.repository.RebRepository;
import com.toto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class rebootServiceImp implements rebootService {

    @Autowired
    private RebRepository rebRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Reb> getAllPendingReboots() {
        return rebRepository.findAll();
    }

    @Override
    public List<Reb> getPendingRebootsByZone(String zone) {
        return rebRepository.findAllByZoneId(zone);
    }

    @Override
    public void checkReboot(String Id, Long rebId) {
        System.out.println(Id);
        System.out.println(rebId);
        Reb pendingReb=rebRepository.getRebById(rebId);
        User user=userRepository.findByEmail(Id);
        LocalDateTime manualRebootTime=LocalDateTime.now();
        pendingReb.setStatus("rebooted");
        pendingReb.setUser(user);
        pendingReb.setManualRebootTime(manualRebootTime);
        rebRepository.save(pendingReb);
    }

}
