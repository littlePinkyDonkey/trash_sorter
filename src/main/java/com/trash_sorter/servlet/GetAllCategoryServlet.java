package com.trash_sorter.servlet;

import com.google.gson.Gson;
import com.trash_sorter.dao.CategoryDAO;
import com.trash_sorter.model.Category;
import com.trash_sorter.model.Tank;
import com.trash_sorter.service.CategoryService;
import com.trash_sorter.service.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/get-all-category")
public class GetAllCategoryServlet extends HttpServlet {

    private CategoryService categoryService = CategoryServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        long tankId = Long.parseLong(req.getParameter("tankId"));

        List<Category> categories = categoryService.getAllCategoryByTankId(tankId);

        resp.getWriter().write(new Gson().toJson(categories));
    }
}
