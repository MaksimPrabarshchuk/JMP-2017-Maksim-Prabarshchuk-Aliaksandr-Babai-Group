package com.github.alebabai.jmp2k17.jdbc.service.impl;

import com.github.alebabai.jmp2k17.jdbc.domain.Message;
import com.github.alebabai.jmp2k17.jdbc.service.MessageFetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class MessageFecherServiceImpl implements MessageFetcherService {

    private static final String SQL = "SELECT TOP(10) * FROM message ORDER BY id;";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageFecherServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Scheduled(fixedDelay = 5000)
    @Override
    public void fetchMessages() {
        jdbcTemplate.query(SQL, (rs, rowNum) -> {
            final int id = rs.getInt("id");
            final int chatId = rs.getInt("chat_id");
            final String body = rs.getString("body");
            final boolean out = rs.getBoolean("out");
            final Date messageDate = rs.getDate("message_date");
            return new Message(id, chatId, body, out, messageDate);
        }).forEach(System.out::println);
    }
}
