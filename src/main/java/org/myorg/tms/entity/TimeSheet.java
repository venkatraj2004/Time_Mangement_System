package org.myorg.tms.entity;

import jakarta.persistence.*;
import lombok.*;
import org.myorg.tms.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "time_sheet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK → Users
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Employee employee;

    private LocalDate date;

    private Double hours;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String rejectionReason;

    private LocalDateTime rejectedAt;
}