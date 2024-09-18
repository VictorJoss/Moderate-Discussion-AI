package com.victordev.moderatediscussionia.persistence.repository;

import com.victordev.moderatediscussionia.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}