package com.trash_sorter.dao;

public interface ManyToManyDAO {
    void makeDependency(long tank_id, long cat_id);
}
