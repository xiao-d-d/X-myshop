package com.j2.myshop.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends BaseServlet {
    public String show(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().println("商品模块的展示");
        return "redirect:/xx";
    }
    public String add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().println("商品模块的添加");
        return "forword:/xx";
    }


}
