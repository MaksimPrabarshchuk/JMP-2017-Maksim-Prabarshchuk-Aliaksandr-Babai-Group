package com.github.alebabai.jmp2k17.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Event {
    private final String label;
    private final String data;
    private final LocalDateTime date;
}
