package com.victordev.moderatediscussionia.persistence.repository;

import com.victordev.moderatediscussionia.persistence.entity.Debate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebateRepository extends JpaRepository<Debate, Long> {
}
