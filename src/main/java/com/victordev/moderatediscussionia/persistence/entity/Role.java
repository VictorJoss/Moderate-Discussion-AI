package com.victordev.moderatediscussionia.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Getter
@Setter
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @Override
    public String getAuthority() {
        if(name == null){
            return null;
        }
        return "ROLE_" + name.name();
    }

    public static enum RoleEnum{
        USER,
        MODERATOR,
        ADMIN,
        SUPER_ADMIN,
        PREMIUM_USER
    }
}