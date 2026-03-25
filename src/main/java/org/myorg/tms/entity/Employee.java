package org.myorg.tms.entity;


import jakarta.persistence.*;
import lombok.*;
import org.myorg.tms.Role;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Self-referencing FK (manager)
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;
}
