package com.toto.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reb")
public class Reb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String machine;

    private String zoneId;

    private LocalDateTime postponedRebootTime;

    private String status; // ok or ko

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = true)
    private User user;

    private LocalDateTime manualRebootTime;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public LocalDateTime getPostponedRebootTime() {
        return postponedRebootTime;
    }

    public void setPostponedRebootTime(LocalDateTime postponedRebootTime) {
        this.postponedRebootTime = postponedRebootTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getManualRebootTime() {
        return manualRebootTime;
    }

    public void setManualRebootTime(LocalDateTime manualRebootTime) {
        this.manualRebootTime = manualRebootTime;
    }
}
