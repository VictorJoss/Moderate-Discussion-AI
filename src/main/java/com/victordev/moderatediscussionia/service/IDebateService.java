package com.victordev.moderatediscussionia.service;

import com.victordev.moderatediscussionia.persistence.entity.Debate;

public interface IDebateService {
    Debate createDebate(String topic, String description, Long userId);
}
