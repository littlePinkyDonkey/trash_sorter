package com.trash_sorter.servlet;

import com.trash_sorter.model.Admin;
import com.trash_sorter.service.AdminService;
import com.trash_sorter.service.AdminServiceIMPL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("adminName");
        String password = req.getParameter("adminPassword");

        AdminService service = AdminServiceIMPL.getInstance();

        Admin admin = service.getAdminByName(login);
        if (admin != null && admin.getPassword().equals(password)){
            HttpSession session = req.getSession();
            session.setAttribute("admin",admin);
            resp.setContentType("text/html");
            resp.sendRedirect("admin");
        }else
            resp.sendRedirect("login");
    }
}
