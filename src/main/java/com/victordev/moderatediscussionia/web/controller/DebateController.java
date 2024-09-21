package com.victordev.moderatediscussionia.web.controller;

import com.victordev.moderatediscussionia.persistence.entity.Debate;
import com.victordev.moderatediscussionia.service.IDebateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/debates")
public class DebateController {

    @Autowired
    private IDebateService debateService;

    @PostMapping
    public ResponseEntity<Debate> createDebate(@RequestParam String topic, @RequestParam String description, @RequestParam Long userId) {
        Debate debate = debateService.createDebate(topic, description, userId);
        return ResponseEntity.ok(debate);
    }
}
