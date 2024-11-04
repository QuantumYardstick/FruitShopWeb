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
 * 用于打开editfruit.jsp的动作控制器
 */

@WebServlet(name = "EditfruitServlet", value = "/editfruit.do")
public class EditfruitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数，没有参数代表新增商品，没有参数代表修改商品
        request.setCharacterEncoding("utf-8");
        String sFruitid = request.getParameter("fruitid");
        if (sFruitid == null || sFruitid.equals("")){
            TFruit fruit = new TFruit();//创建一个空的商品对象
            request.setAttribute("fruit",fruit);
        }else {
            int fruitid =Integer.parseInt(sFruitid);//类型转换
            FruitDAO fruitDAO = new FruitDAOImpl();
            TFruit fruit = fruitDAO.getFruitById(fruitid);
            request.setAttribute("fruit",fruit);
        }
        DispatcherUtil.openWeb("editfruit.jsp",request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}