package com.github.alebabai.jmp2k17.service.impl;

import com.github.alebabai.jmp2k17.domain.Event;
import com.github.alebabai.jmp2k17.service.EventsInvokerService;

public class EventsInvokerServiceImpl implements EventsInvokerService {

    @Override
    public void invoke(Event event) {
        System.out.println(event);
    }
}
