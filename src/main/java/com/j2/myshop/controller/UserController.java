package com.j2.myshop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//用户用户模块的controller
@WebServlet("/User")
public class UserController extends BaseServlet {
    public String check(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //1.获取用户名
        //2.调用业务逻辑判断用户是否存在
        //3.响应字符串 1.存在 0.不存在
        return null;
    }
}
