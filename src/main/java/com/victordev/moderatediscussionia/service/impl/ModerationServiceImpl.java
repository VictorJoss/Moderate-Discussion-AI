package com.victordev.moderatediscussionia.service.impl;

import com.victordev.moderatediscussionia.service.IModerationService;
import org.springframework.stereotype.Service;

@Service
public class ModerationServiceImpl implements IModerationService {
    @Override
    public boolean isInappropriateContent(String text) {
        return false;
    }
}
