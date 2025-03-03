package com.dencofamily.popeyes.punch.model;

import java.time.LocalDateTime;

public class Users {
    private String username;
    private String email;
    private Long phone;
    private String password;
    private LocalDateTime createdAt;
    private String role;
    private LocalDateTime lastLogin;

    public Users() {}

    public Users(String username, String email, Long phone, String password, LocalDateTime createdAt, String role, LocalDateTime lastLogin) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.createdAt = createdAt;
        this.role = role;
        this.lastLogin = lastLogin;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getPhone() { return phone; }
    public void setPhone(Long phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getLastLogin() { return lastLogin; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", role='" + role + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
