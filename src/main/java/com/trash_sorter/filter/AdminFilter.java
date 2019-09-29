package com.trash_sorter.filter;



import com.trash_sorter.model.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession();

        Admin admin = (Admin) session.getAttribute("admin");

        if (admin != null){
            chain.doFilter(request,response);
            return;
        }

        ((HttpServletResponse)response).sendRedirect("/login");
    }

    @Override
    public void destroy() {

    }
}
