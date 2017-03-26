package com.github.alebabai.jmp2k17.spring.service.impl;

import com.github.alebabai.jmp2k17.spring.domain.Event;
import com.github.alebabai.jmp2k17.spring.service.EventsFactory;

import java.time.LocalDateTime;

public class EventsFactoryImpl implements EventsFactory {

    private String eventLabel;
    private String eventDataFormat;

    public EventsFactoryImpl(String eventLabel, String eventDataFormat) {
        this.eventLabel = eventLabel;
        this.eventDataFormat = eventDataFormat;
    }

    @Override
    public Event createEvent() {
        final String data = String.format(eventDataFormat, System.currentTimeMillis());
        return new Event(eventLabel, data, LocalDateTime.now());
    }

    public String getEventLabel() {
        return eventLabel;
    }

    public EventsFactoryImpl setEventLabel(String eventLabel) {
        this.eventLabel = eventLabel;
        return this;
    }

    public String getEventDataFormat() {
        return eventDataFormat;
    }

    public EventsFactoryImpl setEventDataFormat(String eventDataFormat) {
        this.eventDataFormat = eventDataFormat;
        return this;
    }
}
