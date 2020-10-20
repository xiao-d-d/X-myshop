package com.j2.myshop.controller.old;

import com.j2.myshop.controller.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController_old extends BaseServlet {
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().println("登录业务逻辑");
        req.getRequestDispatcher("路径").forward(req,resp);
    }
    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().println("登录业务逻辑");
        req.getRequestDispatcher("路径").forward(req,resp);
    }
}
