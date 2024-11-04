package controller;

import dao.FruitDAO;
import dao.FruitDAOImpl;
import model.TFruit;
import utils.DispatcherUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 水果商品详细信息页面数据加载器
 */

@WebServlet(name = "FruitinfoServlet", value = "/fruitinfo.do")
public class FruitinfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sFruitid =request.getParameter("fruitid");
        if (sFruitid != null && !sFruitid.equals("")) {
            int fruitid = Integer.parseInt(sFruitid);
            //调用业务类获取fruitid对应的商品
            FruitDAO fruitDAO = new FruitDAOImpl();
            TFruit fruit = fruitDAO.getFruitById(fruitid);
            request.setAttribute("fruit",fruit);
            DispatcherUtil.openWeb("fruitinfo.jsp",request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}