package com.toto.service.impl;


import com.toto.entity.Reb;
import com.toto.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface rebootService {
    List<Reb> getAllPendingReboots();
    List<Reb> getPendingRebootsByZone(String zone);
    void checkReboot(String userId, Long machineId);
}
