package com.toto.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "audit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "reb", nullable = false)
    private Reb reb;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvoie;

    // Getters and Setters
}

