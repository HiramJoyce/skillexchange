package com.skill.exchange.controller;

import com.alibaba.druid.util.StringUtils;
import com.skill.exchange.domain.News;
import com.skill.exchange.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("add")
    public String add() {
        return "admin/new";
    }

    @PostMapping("add")
    public String add(News news) {
        news.setCreateTime(new Date());
        newsService.create(news);
        return "redirect:/admin/news";
    }

    @GetMapping("delete")
    public String delete(String id) {
        newsService.deleteNewsById(Integer.parseInt(id));
        return "redirect:/admin/news";
    }
}
