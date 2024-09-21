package com.victordev.moderatediscussionia.service;

public interface IVoteService {

    void voteComment(Long commentId, Long userId, boolean isUpvote);
}
