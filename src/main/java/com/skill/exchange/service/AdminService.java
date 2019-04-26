package com.skill.exchange.service;

import com.skill.exchange.domain.Admin;

public interface AdminService {
    Admin login(Admin admin);

    Admin updateAdmin(Admin admin);
}
