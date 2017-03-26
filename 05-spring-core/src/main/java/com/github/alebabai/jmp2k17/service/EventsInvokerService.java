package com.github.alebabai.jmp2k17.service;

import com.github.alebabai.jmp2k17.domain.Event;

public interface EventsInvokerService {
    void invoke(Event event);
}
