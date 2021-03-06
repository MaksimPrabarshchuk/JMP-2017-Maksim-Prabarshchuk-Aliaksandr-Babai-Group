package com.github.alebabai.jmp2k17.jdbc.service.impl;

import com.github.alebabai.jmp2k17.jdbc.domain.Message;
import com.github.alebabai.jmp2k17.jdbc.service.MessageFactory;
import com.github.alebabai.jmp2k17.jdbc.service.MessagePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MessagePublisherServiceImpl implements MessagePublisherService {

    private static final String SQL_TEMPLATE = "INSERT INTO message (id, chat_Id, body, out, message_date) VALUES ('%d', '%d', '%s', '%s', '%s');";

    private final MessageFactory factory;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessagePublisherServiceImpl(MessageFactory factory, JdbcTemplate jdbcTemplate) {
        this.factory = factory;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Scheduled(fixedDelay = 3000)
    @Override
    public void publishMessages() {
        final long before = System.currentTimeMillis();
        factory.createMessages()
                .stream()
                .map(this::getSqlForMessage)
                .forEach(jdbcTemplate::execute);
        final long result = System.currentTimeMillis() - before;
        System.out.println("One by one update mode: " + result);
    }

    @Scheduled(fixedDelay = 3000)
    @Override
    public void publishMessagesBatchMode() {
        final long before = System.currentTimeMillis();
        final String[] sqlArray = factory.createMessages()
                .stream()
                .map(this::getSqlForMessage)
                .collect(Collectors.toList())
                .toArray(new String[0]);
        jdbcTemplate.batchUpdate(sqlArray);
        final long result = System.currentTimeMillis() - before;
        System.out.println("Batch update mode: " + result);
    }

    private String getSqlForMessage(Message message) {
        return String.format(SQL_TEMPLATE, message.getId(), message.getChatId(), message.getBody(), message.isOut(), message.getMessageDate());
    }
}
