package com.victordev.moderatediscussionia.service;

import com.victordev.moderatediscussionia.persistence.entity.Comment;

public interface ICommentService {

    Comment addComment(String content, Long debateId, Long userId);
}
