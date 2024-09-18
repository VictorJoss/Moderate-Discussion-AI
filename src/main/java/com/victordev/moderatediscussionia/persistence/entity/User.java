package com.victordev.moderatediscussionia.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Integer score;

    @OneToMany(mappedBy = "user")
    private List<Debate> debates;

    @OneToMany(mappedBy = "user")
    private List<Vote> votes;
}