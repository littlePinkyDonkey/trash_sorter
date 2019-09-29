package com.trash_sorter.service;

import com.trash_sorter.model.Tank;

import java.util.List;

public interface TankService {
    boolean addNewTank(Tank tankName);
    boolean deleteTank(Tank tank);
    Tank getTankById(long id);
    List<Tank> getTanks();
    Tank  getTankByName(String name);
    boolean addQR(String qr, long id);
}
