package com.skill.exchange.service.impl;

import com.skill.exchange.dao.SkillMapper;
import com.skill.exchange.dao.StudentMapper;
import com.skill.exchange.domain.Skill;
import com.skill.exchange.domain.SkillExample;
import com.skill.exchange.domain.Student;
import com.skill.exchange.domain.StudentExample;
import com.skill.exchange.service.SkillService;
import com.skill.exchange.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillMapper skillMapper;

    @Override
    public List<Skill> getAllSkills() {
        return skillMapper.selectByExample(new SkillExample());
    }

    @Override
    public int deleteSkillById(Integer id) {
        return skillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Skill getSkillById(Integer id) {
        return skillMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Skill> getAllSkillsByStudentId(Integer studentId) {
        SkillExample skillExample = new SkillExample();
        SkillExample.Criteria criteria = skillExample.createCriteria();
        criteria.andStudentIdEqualTo(studentId);
        return skillMapper.selectByExample(skillExample);
    }

    @Override
    public List<Skill> getAllTrueSkillsByStudentId(Integer studentId) {
        SkillExample skillExample = new SkillExample();
        SkillExample.Criteria criteria = skillExample.createCriteria();
        criteria.andStudentIdEqualTo(studentId).andStateEqualTo(true);
        return skillMapper.selectByExample(skillExample);
    }

    @Override
    public List<Skill> search(String keyWord) {
        return skillMapper.selectByKeyWord(keyWord);
    }

    @Override
    public int agree(Integer id) {
        Skill skill = skillMapper.selectByPrimaryKey(id);
        skill.setState(true);
        System.out.println(skill);
        return skillMapper.updateByPrimaryKey(skill);
    }

    @Override
    public int updateSkill(Skill skill) {
        return skillMapper.updateByPrimaryKey(skill);
    }

    @Override
    public int createSkill(Skill skill) {
        return skillMapper.insert(skill);
    }

    @Override
    public List<Skill> getAllTrueSkills() {
        SkillExample skillExample = new SkillExample();
        SkillExample.Criteria criteria = skillExample.createCriteria();
        criteria.andStateEqualTo(true);
        return skillMapper.selectByExample(skillExample);
    }
}
