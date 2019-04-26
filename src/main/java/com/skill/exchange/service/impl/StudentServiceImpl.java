package com.skill.exchange.service.impl;

import com.skill.exchange.dao.StudentMapper;
import com.skill.exchange.domain.Student;
import com.skill.exchange.domain.StudentExample;
import com.skill.exchange.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(Student student) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStudentNumEqualTo(student.getStudentNum()).andPasswordEqualTo(student.getPassword());
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students != null && students.size() > 0 ? students.get(0) : null;
    }

    @Override
    public Student register(Student student) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStudentNumEqualTo(student.getStudentNum());
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students != null && students.size() > 0) {
            return null;
        }
        studentMapper.insert(student);
        criteria.andStudentNumEqualTo(student.getStudentNum()).andPasswordEqualTo(student.getPassword());
        List<Student> students2 = studentMapper.selectByExample(studentExample);
        return students2 != null && students2.size() > 0 ? students2.get(0) : null;
    }

    @Override
    public Student updateStudent(Student student) {
        return studentMapper.updateByPrimaryKey(student) > 0 ? student : null;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectByExample(new StudentExample());
    }

    @Override
    public int deleteStudentById(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
