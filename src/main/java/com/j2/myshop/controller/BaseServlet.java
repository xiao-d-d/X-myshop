package com.j2.myshop.controller;
import com.j2.myshop.utils.Constants;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//BaseServlet用于集中处理方法的调用！
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //11.获取请求参数（标识符）
        String methodStr = req.getParameter(Constants.TAG);
        //22.如果method没有获取到值！我们就跳转到首页！（标识符异常处理）
        if(methodStr==null&methodStr.equals("")){
            methodStr= com.j2.myshop.utils.Constants.INDEX;
        }
        //33利用反射调用对应业务逻辑
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
            //44.集中处理返回值响应
            if(result!=null){
                //转发 重定向 返回字符
                String str=(String) result;
                //str.startsWith("forword:")
                if(str.startsWith(Constants.FORWARD)){
                    //String path = str.substring(str.indexOf(":") + 1);
                    String path = str.substring(str.indexOf(Constants.FLAG) + 1);
                    req.getRequestDispatcher(path).forward(req,resp);
                    //str.startsWith("redirect:")
                }else if(str.startsWith(Constants.REDIRECT)){
                    //重定向
                    String path = str.substring(str.indexOf(Constants.FLAG) + 1);
                    resp.sendRedirect(path);
                }else {
                    resp.getWriter().println(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //没有反射到方法
            req.getSession().setAttribute("msg", "程序异常!请稍后再试！");
            resp.sendRedirect("/message.jsp");
        }
    }
    private String index(HttpServletRequest request, HttpServletResponse response) {
        return Constants.FORWARD +"/index.jsp";
    }
}
