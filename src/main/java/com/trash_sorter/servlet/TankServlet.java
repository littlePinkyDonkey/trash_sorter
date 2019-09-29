package com.trash_sorter.servlet;

import com.trash_sorter.service.TankService;
import com.trash_sorter.service.TankServiceIMPL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tank")
public class TankServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string_id = req.getParameter("id");
        long id = Long.parseLong(string_id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);
    }
}
