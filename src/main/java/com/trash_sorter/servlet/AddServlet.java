package com.trash_sorter.servlet;

import com.trash_sorter.model.Category;
import com.trash_sorter.model.Tank;
import com.trash_sorter.model.Trash;
import com.trash_sorter.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String itemType = "tank_add";//req.getParameter("itemType");
        String itemName = req.getParameter("tankName");
        switch (itemType){
            case "tank_add":
                TankService tank_service = TankServiceIMPL.getInstance();
                //обавляем в таблицу новый бак, тем самым прихерачив к нему id
                //имея его, мы могём сгенерить qr и присобачить его update'ом
                //getTankByID()
                Tank tank = new Tank(itemName);
                tank_service.addNewTank(tank);
                long id = tank_service.getTankByName(itemName).getId();
                String qr = new QrService().getQrUrl(id,300);
                tank_service.addQR(qr,id);
                break;
            case "category_add":
                CategoryService category_service = CategoryServiceImpl.getInstance();
                category_service.addNewCategory(new Category(itemName));
                break;
            case "trash_add":
                TrashService trash_service = TrashServiceIMPL.getInstance();
                trash_service.addNewTrash(new Trash(itemName));
                break;
        }
        resp.setContentType("text/html");
        resp.sendRedirect("/admin");
    }
}
