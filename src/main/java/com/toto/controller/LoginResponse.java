package com.toto.controller;

public class LoginResponse {
    private String role;
    private String zone;
    private String name;
    private String email;

    public LoginResponse(String role, String zone, String name, String email) {
        this.role = role;
        this.zone = zone;
        this.name = name;
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
