package com.victordev.moderatediscussionia.persistence.repository;

import com.victordev.moderatediscussionia.persistence.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
