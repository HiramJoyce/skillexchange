package com.skill.exchange.controller;

import com.alibaba.druid.util.StringUtils;
import com.skill.exchange.domain.Skill;
import com.skill.exchange.domain.Student;
import com.skill.exchange.domain.Trade;
import com.skill.exchange.service.SkillService;
import com.skill.exchange.service.StudentService;
import com.skill.exchange.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("trade")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @GetMapping("update")
    public String update(String id) {
        tradeService.agreeTrade(Integer.valueOf(id));
        return "redirect:/student/trades";
    }

    @GetMapping("delete")
    public String delete(String id, String role) {
        tradeService.deleteTradeById(Integer.parseInt(id));
        if (role != null && StringUtils.equals(role, "admin")) {
            return "redirect:/admin/trades";
        } else {
            return "redirect:/student/trades";
        }
    }
}
