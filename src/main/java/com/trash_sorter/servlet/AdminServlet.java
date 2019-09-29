package com.trash_sorter.servlet;

import com.trash_sorter.model.Category;
import com.trash_sorter.model.Tank;
import com.trash_sorter.model.Trash;
import com.trash_sorter.service.CategoryServiceImpl;
import com.trash_sorter.service.TankServiceIMPL;
import com.trash_sorter.service.TrashServiceIMPL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TankServiceIMPL tanks_service = TankServiceIMPL.getInstance();
        CategoryServiceImpl category_service = CategoryServiceImpl.getInstance();
        TrashServiceIMPL trash_service = TrashServiceIMPL.getInstance();

        List<Tank> tanks = tanks_service.getTanks();
        List<Category> categories = category_service.getAllCategories();
        List<Trash> trash = trash_service.getAllTrash();

        req.setAttribute("tanks", tanks);
        req.setAttribute("categories", categories);
        req.setAttribute("trash",trash);

        resp.setContentType("text/html");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(req,resp);
    }
}
