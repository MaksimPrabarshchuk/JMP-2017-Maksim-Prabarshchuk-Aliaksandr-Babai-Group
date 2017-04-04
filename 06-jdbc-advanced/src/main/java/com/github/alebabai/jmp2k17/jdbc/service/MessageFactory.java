package com.github.alebabai.jmp2k17.jdbc.service;

import com.github.alebabai.jmp2k17.jdbc.domain.Message;

import java.util.List;

public interface MessageFactory {
    Message createMessage();

    List<Message> createMessages();
}
