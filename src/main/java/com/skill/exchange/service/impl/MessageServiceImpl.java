package com.skill.exchange.service.impl;

import com.skill.exchange.dao.MessageMapper;
import com.skill.exchange.dao.NewsMapper;
import com.skill.exchange.domain.Message;
import com.skill.exchange.domain.MessageExample;
import com.skill.exchange.domain.News;
import com.skill.exchange.domain.NewsExample;
import com.skill.exchange.service.MessageService;
import com.skill.exchange.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> getAllMessages() {
        return messageMapper.selectByExample(new MessageExample());
    }

    @Override
    public List<Message> getAllTrueMessages() {
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andStateEqualTo(true);
        return messageMapper.selectByExample(messageExample);
    }

    @Override
    public int deleteMessageById(Integer id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Message getMessageById(Integer id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public int agree(Integer id) {
        Message message = messageMapper.selectByPrimaryKey(id);
        message.setState(true);
        return messageMapper.updateByPrimaryKey(message);
    }
}
