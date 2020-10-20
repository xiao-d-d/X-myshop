package com.j2.myshop.controller;

/*import com.qf.ran.entity.User;
import com.qf.ran.service.IUserService;
import com.qf.ran.service.impl.UserServiceImpl;*/

import com.j2.myshop.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/UserServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodStr = req.getParameter("method");
        if(methodStr==null&methodStr.equals("")){
            methodStr= com.j2.myshop.utils.Constants.INDEX;
        }
        //调用反射技术
        //1.获取类的class对象
        Class clazz = this.getClass();
        //2.获取方法
        try {
            Method method = clazz.getMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class);
            //3.执行方法
            Object result = method.invoke(this, req, resp);
            /*if(result!=null){
                String path=(String) result;
                req.getRequestDispatcher(path).forward(req,resp);
            }*/
            if(result!=null){
                //转发 重定向 返回字符
                String str=(String) result;
                if(str.startsWith("forword:")){                    //转发
                    String path = str.substring(str.indexOf(":") + 1);
                    req.getRequestDispatcher(path).forward(req,resp);
                }else if(str.startsWith("redirect:")){
                    //重定向
                    String path = str.substring(str.indexOf(":") + 1);
                    resp.sendRedirect(path);
                }else {
                    resp.getWriter().println(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //没有反射到方法
        }
    }
    private String index(HttpServletRequest request, HttpServletResponse response) {
        return Constants.FORWARD +"/index.jsp";
    }
}
