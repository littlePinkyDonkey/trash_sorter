package com.trash_sorter.service;


import com.trash_sorter.dao.AdminDAO;
import com.trash_sorter.dao.AdminDaoImpl;
import com.trash_sorter.model.Admin;
import com.trash_sorter.util.Builder;
import com.trash_sorter.util.DbHelper;

public class AdminServiceIMPL implements AdminService {
    DbHelper helper = DbHelper.getInstance(Builder.getConfiguration());
    private AdminDAO dao;

    private static volatile AdminServiceIMPL instance;
    private AdminServiceIMPL(){
        this.dao = new AdminDaoImpl(helper.getFactory());
    }
    public static AdminServiceIMPL getInstance(){
        if (instance == null){
            synchronized (AdminServiceIMPL.class){
                if (instance == null){
                    instance = new AdminServiceIMPL();
                }
            }
        }
        return instance;
    }

    @Override
    public Admin getAdminByName(String adminName) {
        return dao.getAdminByName(adminName);
    }
}
