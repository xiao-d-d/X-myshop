package com.j2.myshop.controller.old;

import com.j2.myshop.controller.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController_old1 extends BaseServlet {
    //登录
    //1.获取请求参数request
    //2.调用业务逻辑service
    //3.响应(转发，重定向，返回字符串(json)，返回字节) response
    public String login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().println("登录业务逻辑");
        //req.getRequestDispatcher("路径").forward(req,resp);
        //转发 forward:/路径
        //重定向 redirect:/路径
        //字符串 {}json
        //字节文件 方法返回值类型void 使用response对象手动写回
        return "{name:'xxx'}";
    }
    //注册
    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().println("注册业务逻辑");
        //req.getRequestDispatcher("路径").forward(req,resp);
        resp.getOutputStream().write(null);
    }
}
