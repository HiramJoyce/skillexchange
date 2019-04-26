package com.skill.exchange.service.impl;

import com.skill.exchange.dao.NewsMapper;
import com.skill.exchange.dao.TradeMapper;
import com.skill.exchange.domain.News;
import com.skill.exchange.domain.NewsExample;
import com.skill.exchange.domain.Trade;
import com.skill.exchange.domain.TradeExample;
import com.skill.exchange.service.NewsService;
import com.skill.exchange.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> getAllNews() {
        return newsMapper.selectByExample(new NewsExample());
    }

    @Override
    public int deleteNewsById(Integer id) {
        return newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public News getNewsById(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(News news) {
        return newsMapper.insert(news);
    }
}
