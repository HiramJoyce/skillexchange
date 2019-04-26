package com.skill.exchange.service;

import com.skill.exchange.domain.News;

import java.util.List;

public interface NewsService {
    List<News> getAllNews();

    int deleteNewsById(Integer id);

    News getNewsById(Integer id);

    int create(News news);
}
