package com.github.alebabai.jmp2k17.jdbc.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Accessors(chain = true)
public class Message {
    private final Integer id;
    private final Integer chatId;
    private final String body;
    private final boolean out;
    private final Date messageDate;
}
