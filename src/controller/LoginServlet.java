package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.TUser;
import utils.DispatcherUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录控制器
 */

@WebServlet(name = "LoginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数，做数据校验
        request.setCharacterEncoding("utf-8");
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        if(userid==null || userid.equals("")){
            DispatcherUtil.openErrWeb("用户登录账号不能为空",
                    "login.jsp",request,response);
            return;
        }
        if(password==null || password.equals("")){
            DispatcherUtil.openErrWeb("用户登录密码不能为空",
                    "login.jsp",request,response);
            return;
        }
        //调用业务类实现用户身份验证，根据结果返回网页
        UserDAO userDAO = new UserDAOImpl();
        TUser loginuser = userDAO.login(userid,password);
        if(loginuser==null || loginuser.getUserid()==null){
            DispatcherUtil.openErrWeb("您输入的用户登录账号和密码不正确",
                    "login.jsp",request,response);
        }else{
            //成功，把登录用户对象存入到session中
            HttpSession session = request.getSession();
            session.setAttribute("loginuser",loginuser);
            response.sendRedirect("index.do"); //回到主页
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}