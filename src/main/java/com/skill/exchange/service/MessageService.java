package com.skill.exchange.service;

import com.skill.exchange.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessages();

    List<Message> getAllTrueMessages();

    int deleteMessageById(Integer id);

    Message getMessageById(Integer id);

    int create(Message message);

    int agree(Integer id);
}
