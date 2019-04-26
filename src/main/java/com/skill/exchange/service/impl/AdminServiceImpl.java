package com.skill.exchange.service.impl;

import com.skill.exchange.dao.AdminMapper;
import com.skill.exchange.dao.StudentMapper;
import com.skill.exchange.domain.Admin;
import com.skill.exchange.domain.AdminExample;
import com.skill.exchange.domain.Student;
import com.skill.exchange.domain.StudentExample;
import com.skill.exchange.service.AdminService;
import com.skill.exchange.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUserNameEqualTo(admin.getUserName()).andPasswordEqualTo(admin.getPassword());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        return admins != null && admins.size() > 0 ? admins.get(0) : null;
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin) > 0 ? admin : null;
    }
}
