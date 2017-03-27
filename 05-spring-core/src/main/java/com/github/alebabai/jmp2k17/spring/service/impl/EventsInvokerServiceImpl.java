package com.github.alebabai.jmp2k17.spring.service.impl;

import com.github.alebabai.jmp2k17.spring.domain.Event;
import com.github.alebabai.jmp2k17.spring.service.EventsInvokerService;

public class EventsInvokerServiceImpl implements EventsInvokerService {

    @Override
    public void invoke(Event event) {
        System.out.println(event);
    }
}
