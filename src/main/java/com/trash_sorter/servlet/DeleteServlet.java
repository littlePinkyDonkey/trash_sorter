package com.trash_sorter.servlet;

import com.trash_sorter.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String table_name = req.getParameter("item");

        switch (table_name){
            case "tank":
                TankService tank_service = TankServiceIMPL.getInstance();
                tank_service.deleteTank(tank_service.getTankById(id));
                break;
            case "category":
                CategoryService category_service = CategoryServiceImpl.getInstance();
                category_service.deleteCategory(category_service.getCategoryById(id));
                break;
            case "trash":
                TrashService trash_service = TrashServiceIMPL.getInstance();
                trash_service.deleteTrash(trash_service.getTrashById(id));
                break;
        }

        resp.setContentType("text/html");
        resp.sendRedirect("/admin");
    }
}
