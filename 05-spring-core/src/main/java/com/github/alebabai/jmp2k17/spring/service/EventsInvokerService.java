package com.github.alebabai.jmp2k17.spring.service;

import com.github.alebabai.jmp2k17.spring.domain.Event;

public interface EventsInvokerService {
    void invoke(Event event);
}
