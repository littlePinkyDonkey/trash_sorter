package com.trash_sorter.service;

import com.trash_sorter.dao.ManyToManyDAO;
import com.trash_sorter.dao.ManyToManyDaoImpl;
import com.trash_sorter.util.Builder;
import com.trash_sorter.util.DbHelper;

public class ManyToManyServiceIMPL implements ManyToManyService {
    DbHelper helper = DbHelper.getInstance(Builder.getConfiguration());
    private final ManyToManyDAO dao;

    private static volatile ManyToManyServiceIMPL instance;
    private ManyToManyServiceIMPL(){
        this.dao = new ManyToManyDaoImpl(helper.getFactory());
    }
    public static ManyToManyServiceIMPL getInstance(){
        if (instance == null){
            synchronized (ManyToManyServiceIMPL.class){
                if (instance == null)
                    instance = new ManyToManyServiceIMPL();
            }
        }
        return instance;
    }

    @Override
    public void makeDependency(long tank_id, long cat_id) {
        dao.makeDependency(tank_id,cat_id);
    }
}
