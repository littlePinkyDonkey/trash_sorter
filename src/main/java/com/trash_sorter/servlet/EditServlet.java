package com.trash_sorter.servlet;

import com.google.gson.Gson;
import com.trash_sorter.model.Category;
import com.trash_sorter.model.Tank;
import com.trash_sorter.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/edit")
public class EditServlet extends HttpServlet {
    private CategoryService categoryService = CategoryServiceImpl.getInstance();
    private TankService tankService = TankServiceIMPL.getInstance();
    /**
     * все изменения нужны для привязки к категориям
     * получаем список всех категорий и перекидываем на edit.jsp
     * просто отрисовка страницы
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long tankId = Long.parseLong(req.getParameter("id"));
        List<Category> categories = categoryService.getAllCategories();
        Tank tank = tankService.getTankById(tankId);
        req.setAttribute("tank", tank);
        req.setAttribute("categs",categories);
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String jsonOutput = req.getParameter("ids");
        long tank_id = Long.parseLong(req.getParameter("tankId"));
        String itemType = req.getParameter("itemType");
        int[] posts = gson.fromJson(jsonOutput, int[].class);
        switch (itemType){
            case "tank":
                ManyToManyService many_to_many_service = ManyToManyServiceIMPL.getInstance();
                for (int i = 0; i < posts.length; i++){
                    long cat_id = (long) posts[i];
                    many_to_many_service.makeDependency(tank_id, cat_id);
                }
                break;
            case "trash":
                TrashService trash_service = TrashServiceIMPL.getInstance();
                for(int i = 0; i < posts.length; i++){
                    long cat_id = (long) posts[i];
                    trash_service.addNewCategory(tank_id,cat_id);
                }
                break;
        }
    }
}
