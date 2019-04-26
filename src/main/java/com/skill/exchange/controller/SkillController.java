package com.skill.exchange.controller;

import com.alibaba.druid.util.StringUtils;
import com.skill.exchange.domain.News;
import com.skill.exchange.domain.Skill;
import com.skill.exchange.domain.Student;
import com.skill.exchange.domain.Trade;
import com.skill.exchange.service.NewsService;
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
@RequestMapping("skill")
public class SkillController {

    @Autowired
    private SkillService skillService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TradeService tradeService;
    @Autowired
    private NewsService newsService;

    @PostMapping("update")
    public String update(Skill skill, @RequestParam(value = "imgFile", required = false) MultipartFile imgFile, Model model, HttpServletRequest request) throws IOException {
        String newFileName = null;
        if (!imgFile.isEmpty()) {
            String path = request.getServletContext().getRealPath("/resource/uploadImg/");
            File dir = new File(path);
            boolean dirExist = dir.exists() || dir.mkdirs();
            if (dirExist) {
                String originalFileName = imgFile.getOriginalFilename();
                newFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileName.substring(originalFileName.lastIndexOf("."));
                File newFile = new File(path + "/" + newFileName);
                imgFile.transferTo(newFile);
            }
        }
        if (skill.getId() != null) {
            if (newFileName != null) {
                skill.setImg(newFileName);
            }
            System.out.println("update -> " + skill.toString());
            skillService.updateSkill(skill);
        } else {
            if (newFileName != null) {
                skill.setImg(newFileName);
            }
            skill.setCreateTime(new Date());
            skill.setState(false);
            System.out.println("create -> " + skill.toString());
            skillService.createSkill(skill);
        }
        return "redirect:/student/skills";
    }

    @GetMapping("delete")
    public String delete(String id, String role) {
        skillService.deleteSkillById(Integer.parseInt(id));
        if (role != null && StringUtils.equals(role, "admin")) {
            return "redirect:/admin/skills";
        } else {
            return "redirect:/student/skills";
        }
    }

    @GetMapping("info")
    public String info(String id, Model model, HttpSession session) {
        if (session.getAttribute("id") == null) {
            return "redirect:/login";
        }
        Skill skillById = skillService.getSkillById(Integer.valueOf(id));
        model.addAttribute("skill", skillById);
        List<Skill> skills = skillService.getAllTrueSkillsByStudentId((Integer) session.getAttribute("id"));
        model.addAttribute("skills", skills);
        List<Trade> trades = tradeService.getMostPopularSkill();
        model.addAttribute("trades", trades);
        List<News> allNews = newsService.getAllNews();
        model.addAttribute("news", allNews);
        return "skillInfo";
    }

    @PostMapping("exchange")
    public String exchange(Trade trade) {
        Student studentById = studentService.getStudentById(trade.getFromStudentId());
        trade.setFromStudentNum(studentById.getStudentNum());
        trade.setFromStudentRealName(studentById.getRealUame());
        Skill fromSkillById = skillService.getSkillById(trade.getFromSkillId());
        trade.setFromSkillTitle(fromSkillById.getTitle());
        Skill toSkillById = skillService.getSkillById(trade.getToSkillId());
        trade.setToStudentId(toSkillById.getStudentId());
        trade.setToStudentNum(toSkillById.getStudentNum());
        trade.setToStudentRealName(toSkillById.getStudentRealName());
        trade.setToSkillTitle(toSkillById.getTitle());
        trade.setCreateTime(new Date());
        trade.setState(0);
        System.out.println(trade);
        tradeService.createTrade(trade);
        return "redirect:/student/trades";
    }

    @PostMapping("search")
    public String search(String keyWord, Model model) {
        List<Skill> skills = skillService.search(keyWord);
        model.addAttribute("skills", skills);
        List<Trade> trades = tradeService.getMostPopularSkill();
        model.addAttribute("trades", trades);
        List<News> allNews = newsService.getAllNews();
        model.addAttribute("news", allNews);
        return "index";
    }

    @GetMapping("agree")
    public String agree(String id) {
        skillService.agree(Integer.valueOf(id));
        return "redirect:/admin/skills";
    }
}
