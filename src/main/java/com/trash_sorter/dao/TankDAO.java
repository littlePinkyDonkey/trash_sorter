package com.trash_sorter.dao;

import com.trash_sorter.model.Tank;

import java.util.List;

public interface TankDAO {
    boolean addNewTank(Tank tankName);
    boolean deleteTank(Tank tank);
    Tank getTankById(long id);
    List<Tank> getTanks();
    Tank  getTankByName(String name);
    boolean addQR(String qr, long id);
}
