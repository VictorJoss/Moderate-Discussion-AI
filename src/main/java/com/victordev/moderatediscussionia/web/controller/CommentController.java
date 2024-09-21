package com.victordev.moderatediscussionia.web.controller;

import com.victordev.moderatediscussionia.persistence.entity.Comment;
import com.victordev.moderatediscussionia.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestParam String content, @RequestParam Long debateId, @RequestParam Long userId) {
        Comment comment = commentService.addComment(content, debateId, userId);
        return ResponseEntity.ok(comment);
    }
}
