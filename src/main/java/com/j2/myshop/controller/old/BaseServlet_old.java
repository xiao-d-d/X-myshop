package com.j2.myshop.controller.old;

/*import com.qf.ran.entity.User;
import com.qf.ran.service.IUserService;
import com.qf.ran.service.impl.UserServiceImpl;*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/UserServlet")
public class BaseServlet_old extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        //调用反射技术
        //1.获取类的class对象
        Class clazz = this.getClass();
        //2.获取方法
        try {
            Method method1 = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //3.执行方法
            method1.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            //没有反射到方法
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    private void login(HttpServletRequest request, HttpServletResponse response) {
    }
    private void register(HttpServletRequest request, HttpServletResponse response) {
    }
}
