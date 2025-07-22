package com.example.zidio_connect_spring.entity;
import com.example.zidio_connect_spring.Enum.AccountStatus;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "Recruiter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {
    @Id
    private UUID recruiterId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "recruiter_id")
    private User user;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private String companyName;

    private String companyWebsite;
    private String companyLogoUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accountStatus;

    private boolean verifiedByAdmin = false;
}

