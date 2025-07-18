package com.example.zidio_connect_spring.entity;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Admin {
    @Id
    private UUID adminId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "admin_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdminRole adminRole;

    @Column(nullable = false)
    private int permissionsLevel;

    private Timestamp lastLogin;
    private boolean isActive = true;

    // Getters, Setters
}

