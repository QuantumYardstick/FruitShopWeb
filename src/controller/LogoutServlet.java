package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 退出登录操作
 */

@WebServlet(name = "LogoutServlet", value = "/logout.do")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //退出登录就是将session 中的Loginuser删除
        HttpSession session = request.getSession();
        session.removeAttribute("loginuser");
        response.sendRedirect("index.do");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}