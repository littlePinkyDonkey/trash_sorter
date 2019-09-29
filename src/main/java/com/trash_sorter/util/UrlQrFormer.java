package com.trash_sorter.util;

import com.trash_sorter.model.Tank;
import com.trash_sorter.service.QrService;
import com.trash_sorter.service.TankServiceIMPL;

import java.util.List;

public class UrlQrFormer {
    public static void main(String[] args) {
        List<Tank> tanks = TankServiceIMPL.getInstance().getTanks();
        QrService qrService = new QrService();
        for (Tank tank : tanks) {
            String qr = qrService.getQrUrl(tank.getId(), 300);
            TankServiceIMPL.getInstance().addQR(qr, tank.getId());
        }
    }
}
