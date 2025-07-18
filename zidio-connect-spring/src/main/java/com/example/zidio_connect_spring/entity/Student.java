package com.example.zidio_connect_spring.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private UUID studentId; // same as userId

    @OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    private User user;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false, unique = true)
    private String enrollmentNumber;

    @Column(nullable = false)
    private String course;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private YearOfStudy yearOfStudy;

    @Column(nullable = false)
    private String department;
}

