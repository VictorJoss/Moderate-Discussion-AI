package com.victordev.moderatediscussionia.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Debate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToMany(mappedBy = "debate")
    private List<Comment> comments;
}
