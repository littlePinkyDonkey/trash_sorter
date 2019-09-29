package com.trash_sorter.service;

import com.trash_sorter.model.Admin;

public interface AdminService {
    Admin getAdminByName(String adminName);
}
