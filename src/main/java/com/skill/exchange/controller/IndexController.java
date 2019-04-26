package com.skill.exchange.controller;

import com.skill.exchange.domain.News;
import com.skill.exchange.domain.Skill;
import com.skill.exchange.domain.Trade;
import com.skill.exchange.service.NewsService;
import com.skill.exchange.service.SkillService;
import com.skill.exchange.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private SkillService skillService;
    @Autowired
    private TradeService tradeService;
    @Autowired
    private NewsService newsService;

    @GetMapping("")
    public String index(Model model) {
        List<Skill> skills = skillService.getAllTrueSkills();
        model.addAttribute("skills", skills);
        List<Trade> trades = tradeService.getMostPopularSkill();
        model.addAttribute("trades", trades);
        List<News> allNews = newsService.getAllNews();
        model.addAttribute("news", allNews);
        return "index";
    }
    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
