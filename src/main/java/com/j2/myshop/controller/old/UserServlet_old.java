package com.j2.myshop.controller.old;

/*import com.qf.ran.entity.User;
import com.qf.ran.service.IUserService;
import com.qf.ran.service.impl.UserServiceImpl;*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Ran
 * @since JDK 1.8
 */
//@WebServlet("/UserServlet")
public class UserServlet_old extends HttpServlet {
    //private IUserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String method = request.getParameter("action");
      /*  switch (action){
            case "getList":
                getList(request,response);
                break;
            default:
                break;
        }*/
        switch (method){
            case "login":
                login(request,response);
                break;
            case "register":
                register(request,response);
                break;
            default:
                response.getWriter().println("没有有效的处理方案！");
        }
        //调用反射技术
        //1.获取类的class对象
        Class<? extends UserServlet_old> clazz = this.getClass();
        //2.获取方法
        try {
            Method method1 = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            method1.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            //没有反射到方法
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.执行方法
    }


    private void login(HttpServletRequest request, HttpServletResponse response) {
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//1.获取前端数据  --  当前页
        String currentPage = request.getParameter("currentPage");
        //2.设置每页展示的数据行
        int pageSize = 3;
        //3.获取总条数
        int totalCount = userService.getTotalCount();
        //4.获取总页数
        int pageCount = totalCount%pageSize == 0?totalCount/pageSize:totalCount/pageSize+1;
        //5.获取每页展示的数据
        List<User> list = userService.getList((Integer.parseInt(currentPage)-1)*pageSize,pageSize);
        //6.响应前端
        request.setAttribute("list",list);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("userList.jsp").forward(request,response);*/
    }
}
