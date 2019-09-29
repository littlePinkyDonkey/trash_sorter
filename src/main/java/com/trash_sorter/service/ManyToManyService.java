package com.trash_sorter.service;

public interface ManyToManyService {
    void makeDependency(long tank_id, long cat_id);
}
