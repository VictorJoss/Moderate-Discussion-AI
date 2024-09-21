package com.victordev.moderatediscussionia.service.impl;

import com.victordev.moderatediscussionia.persistence.entity.Comment;
import com.victordev.moderatediscussionia.persistence.entity.Debate;
import com.victordev.moderatediscussionia.persistence.entity.User;
import com.victordev.moderatediscussionia.persistence.repository.CommentRepository;
import com.victordev.moderatediscussionia.persistence.repository.DebateRepository;
import com.victordev.moderatediscussionia.persistence.repository.UserRepository;
import com.victordev.moderatediscussionia.service.ICommentService;
import com.victordev.moderatediscussionia.service.IModerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private IModerationService moderationService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private DebateRepository debateRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment addComment(String content, Long debateId, Long userId) {
        if (moderationService.isInappropriateContent(content)) {
            throw new RuntimeException("Inappropriate content detected");
        }

        Debate debate = debateRepository.findById(debateId).orElseThrow(() -> new RuntimeException("Debate not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setDebate(debate);
        comment.setUser(user);
        comment.setCreationDate(LocalDateTime.now());

        return commentRepository.save(comment);
    }
}
