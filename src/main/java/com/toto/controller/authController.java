package com.toto.controller;


import com.toto.entity.User;
import com.toto.service.impl.authService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class authController {
    @Autowired
    private authService authService;



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req){
        User userTryingToLog = authService.getUserByEmail(req.getEmail());
        if (userTryingToLog!=null && authService.checkPassword(userTryingToLog, req.getPassword())) {
            return ResponseEntity.ok(new LoginResponse(userTryingToLog.getRole(), userTryingToLog.getZone(), userTryingToLog.getName(), userTryingToLog.getEmail()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }
}
