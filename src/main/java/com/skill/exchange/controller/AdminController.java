package com.skill.exchange.controller;

import com.skill.exchange.domain.*;
import com.skill.exchange.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private TradeService tradeService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private MessageService messageService;

    @GetMapping("")
    public String index(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "admin/index";
    }

    @GetMapping("students")
    public String students(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "admin/index";
    }

    @GetMapping("skills")
    public String skills(Model model) {
        List<Skill> skills = skillService.getAllSkills();
        model.addAttribute("skills", skills);
        return "admin/skills";
    }

    @GetMapping("trades")
    public String trades(Model model) {
        List<Trade> trades = tradeService.getAllTrades();
        model.addAttribute("trades", trades);
        return "admin/trades";
    }

    @GetMapping("news")
    public String news(Model model) {
        List<News> news = newsService.getAllNews();
        model.addAttribute("news", news);
        return "admin/news";
    }

    @GetMapping("messages")
    public String messages(Model model) {
        List<Message> messages = messageService.getAllMessages();
        model.addAttribute("messages", messages);
        return "admin/messages";
    }

    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("login")
    public String login(Admin admin, HttpSession session) {
        Admin adminDB = adminService.login(admin);
        if (adminDB != null) {
            session.setAttribute("id", adminDB.getId());
            session.setAttribute("userName", adminDB.getUserName());
            session.setAttribute("role", "admin");
            return "redirect:/admin";
        } else {
            return "redirect:/admin/login";
        }
    }
}
