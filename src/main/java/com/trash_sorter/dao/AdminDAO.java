package com.trash_sorter.dao;

import com.trash_sorter.model.Admin;

public interface AdminDAO {
    Admin getAdminByName(String adminName);
}
