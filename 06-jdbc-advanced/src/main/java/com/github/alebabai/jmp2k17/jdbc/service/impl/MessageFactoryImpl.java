package com.github.alebabai.jmp2k17.jdbc.service.impl;

import com.github.alebabai.jmp2k17.jdbc.domain.Message;
import com.github.alebabai.jmp2k17.jdbc.service.MessageFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MessageFactoryImpl implements MessageFactory {

    public static final int MESSAGES_MIN_COUNT = 1;
    public static final int MESSAGES_MAX_COUNT = 100;

    @Override
    public Message createMessage() {
        return new Message(RandomUtils.nextInt(), RandomUtils.nextInt(), RandomStringUtils.randomAlphabetic(114), true, Date.valueOf(LocalDate.now()));
    }

    @Override
    public List<Message> createMessages() {
        final int randomMaxCount = RandomUtils.nextInt(MESSAGES_MIN_COUNT, MESSAGES_MAX_COUNT);
        return IntStream.range(MESSAGES_MIN_COUNT, randomMaxCount)
                .boxed()
                .map(it -> createMessage())
                .collect(Collectors.toList());
    }
}
