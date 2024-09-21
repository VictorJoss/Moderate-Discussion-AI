package com.victordev.moderatediscussionia.service.impl;

import com.victordev.moderatediscussionia.persistence.entity.Comment;
import com.victordev.moderatediscussionia.persistence.repository.CommentRepository;
import com.victordev.moderatediscussionia.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements IVoteService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void voteComment(Long commentId, Long userId, boolean isUpvote) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("Comment not found"));

        if (isUpvote) {
            comment.setUpvotes(comment.getUpvotes() + 1);
        } else {
            comment.setDownvotes(comment.getDownvotes() + 1);
        }

        commentRepository.save(comment);
    }
}
