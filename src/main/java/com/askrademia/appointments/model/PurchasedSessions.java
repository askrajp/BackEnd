package com.askrademia.appointments.model;
import jakarta.persistence.*;


@Entity
public class PurchasedSessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private int sessionsPurchased;
    private String paymentId;
}
