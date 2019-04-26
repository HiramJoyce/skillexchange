package com.skill.exchange.controller;

import com.alibaba.druid.util.StringUtils;
import com.skill.exchange.domain.Message;
import com.skill.exchange.domain.Student;
import com.skill.exchange.service.MessageService;
import com.skill.exchange.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public String message(Model model) {
        List<Message> allMessages = messageService.getAllTrueMessages();
        model.addAttribute("messages", allMessages);
        return "messages";
    }

    @PostMapping("create")
    public String create(Message message) {
        if (message.getStudentId() == null) {
            return "redirect:/login";
        }
        message.setCreateTime(new Date());
        Student studentById = studentService.getStudentById(message.getStudentId());
        message.setStudentNum(studentById.getStudentNum());
        message.setStudentRealName(studentById.getRealUame());
        message.setState(false);
        messageService.create(message);
        return "redirect:/message";
    }

    @GetMapping("update")
    public String update(String id) {
        messageService.agree(Integer.valueOf(id));
        return "redirect:/admin/messages";
    }

    @GetMapping("delete")
    public String delete(String id) {
        messageService.deleteMessageById(Integer.parseInt(id));
        return "redirect:/message";
    }
}
