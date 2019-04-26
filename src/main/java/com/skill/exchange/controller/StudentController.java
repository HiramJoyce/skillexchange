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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private TradeService tradeService;

    @PostMapping("login")
    public String login(Student student, HttpSession session) {
        System.out.println(student);
        Student studentDB = studentService.login(student);
        if (studentDB != null) {
            session.setAttribute("id", studentDB.getId());
            session.setAttribute("studentNum", studentDB.getStudentNum());
            session.setAttribute("realName", studentDB.getRealUame());
            session.setAttribute("role", "student");
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("register")
    public String register(Student student, String role, HttpSession session) {
        System.out.println(student);
        if (student.getId() != null) {
            Student studentDB = studentService.updateStudent(student);
            if (studentDB != null) {
                session.setAttribute("id", studentDB.getId());
                session.setAttribute("studentNum", studentDB.getStudentNum());
                session.setAttribute("realName", studentDB.getRealUame());
                session.setAttribute("role", "student");
            }
            if (role != null && StringUtils.equals(role, "admin")) {
                return "redirect:/student/update?id=" + student.getId();
            } else {
                return "redirect:/student/info?id=" + student.getId();
            }
        } else {
            Student studentDB = studentService.register(student);
            if (studentDB != null) {
                session.setAttribute("id", studentDB.getId());
                session.setAttribute("studentNum", studentDB.getStudentNum());
                session.setAttribute("realName", studentDB.getRealUame());
                session.setAttribute("role", "student");
                return "redirect:/";
            } else {
                return "redirect:/login";
            }
        }
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/admin/students";
    }

    @GetMapping("update")
    public String update(Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "admin/updateStudent";
    }

    @GetMapping("info")
    public String info(Integer id, Model model, HttpSession session) {
        if (id == null) {
            id = (Integer) session.getAttribute("id");
        }
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/info";
    }

    @GetMapping("skills")
    public String skills(Model model, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("id");
        List<Skill> skills = skillService.getAllSkillsByStudentId(studentId);
        model.addAttribute("skills", skills);
        return "student/skills";
    }

    @GetMapping("skill")
    public String skill(String id, Model model) {
        Skill skill = skillService.getSkillById(Integer.parseInt(id == null ? "0" : id));
        model.addAttribute("skill", skill == null ? new Skill() : skill);
        return "student/updateSkill";
    }

    @GetMapping("trades")
    public String trades(Model model, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("id");
        List<Trade> fromTrades = tradeService.getAllTradesByFromStudentId(studentId);
        model.addAttribute("fromTrades", fromTrades);
        List<Trade> toTrades = tradeService.getAllTradesByToStudentId(studentId);
        model.addAttribute("toTrades", toTrades);
        return "student/trades";
    }
}
