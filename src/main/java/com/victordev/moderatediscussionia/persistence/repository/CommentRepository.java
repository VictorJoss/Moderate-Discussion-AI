package com.victordev.moderatediscussionia.persistence.repository;

import com.victordev.moderatediscussionia.persistence.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
