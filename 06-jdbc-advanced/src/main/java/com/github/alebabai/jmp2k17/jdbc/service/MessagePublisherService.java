package com.github.alebabai.jmp2k17.jdbc.service;

import org.springframework.scheduling.annotation.Scheduled;

public interface MessagePublisherService {
    void publishMessages();

    @Scheduled(fixedDelay = 3000)
    void publishMessagesBatchMode();
}
