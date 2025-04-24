package com.toto.controller;

import com.toto.entity.Reb;

import com.toto.service.impl.rebootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/pending")
public class pendingRebootController {
    @Autowired
    private rebootService rebootService;

    @GetMapping
    public List<Reb> getAllPendingRebs() {
        return rebootService.getAllPendingReboots();
    }

    @GetMapping("/currentZone")
    public List<Reb> getPendingRebsByZone(@RequestParam String zone) {return rebootService.getPendingRebootsByZone(zone);}

    @PatchMapping("/check")
    public void checkReboot(@RequestBody CheckRebootRequest request) {rebootService.checkReboot(request.getUserId(), request.getRebootId()); }
}
