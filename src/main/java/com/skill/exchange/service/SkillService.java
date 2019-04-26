package com.skill.exchange.service;

import com.skill.exchange.domain.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> getAllSkills();

    int deleteSkillById(Integer id);

    Skill getSkillById(Integer id);

    List<Skill> getAllSkillsByStudentId(Integer studentId);

    int updateSkill(Skill skill);

    int createSkill(Skill skill);

    List<Skill> getAllTrueSkills();

    List<Skill> getAllTrueSkillsByStudentId(Integer id);

    List<Skill> search(String keyWord);

    int agree(Integer id);
}
