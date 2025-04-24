package com.toto.controller;


public class CheckRebootRequest {
    private String userId;
    private Long rebootId;

    // Getters and setters


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getRebootId() {
        return rebootId;
    }

    public void setRebootId(Long rebootId) {
        this.rebootId = rebootId;
    }
}

