package com.victordev.moderatediscussionia.service.impl;

import com.victordev.moderatediscussionia.persistence.entity.Debate;
import com.victordev.moderatediscussionia.persistence.entity.User;
import com.victordev.moderatediscussionia.persistence.repository.DebateRepository;
import com.victordev.moderatediscussionia.persistence.repository.UserRepository;
import com.victordev.moderatediscussionia.service.IDebateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebateServiceImpl implements IDebateService {
    @Autowired
    private DebateRepository debateRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Debate createDebate(String topic, String description, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Debate debate = new Debate();
        debate.setTopic(topic);
        debate.setDescription(description);
        debate.setCreator(user);
        return debateRepository.save(debate);
    }
}
