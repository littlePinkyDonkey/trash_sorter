package com.trash_sorter.servlet;

import com.google.gson.Gson;
import com.trash_sorter.model.Result;
import com.trash_sorter.model.Trash;
import com.trash_sorter.service.HashSearch;
import com.trash_sorter.service.TrashService;
import com.trash_sorter.service.TrashServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet("/worker")
public class WorkerServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean isvalidate;

        long id = Long.parseLong(req.getParameter("tankId") );
        String code = req.getParameter("barCode");
//        String code =req.getParameter("txts");
        TrashService trashService = TrashServiceIMPL.getInstance();

        String[] barcode = trashService.getTrashName(code);

        List<String> list = trashService.getAllTrashById(id);

        String result = HashSearch.search(trashService.getAllTrashById(id), barcode);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        if (result !=null) {
            isvalidate = true;
            Result trueResult = new Result(code,result, isvalidate);
            resp.getWriter().write(new Gson().toJson(trueResult)); }
        else {
            isvalidate = false;

            List<String> names = trashService.getAllTrash().stream().map(Trash::getName).collect(Collectors.toList());
            String result1 = HashSearch.search(names, barcode);

            Result falseResult = new Result(code,result1, isvalidate);
            resp.getWriter().write(new Gson().toJson(falseResult));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // String json = new Gson().toJson(barCodeList);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
       // resp.getWriter().write(json);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
