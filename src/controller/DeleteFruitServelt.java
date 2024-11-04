package controller;

import dao.FruitDAO;
import dao.FruitDAOImpl;
import model.TFruit;
import utils.DispatcherUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteFruitServelt", value = "/deletefruit.do")
public class DeleteFruitServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数，进行数据校验
        request.setCharacterEncoding("utf-8");//定义字符集
        String sFruitid = request.getParameter("fruitid");
        if (sFruitid != null && !sFruitid.equals("")){
            int fruitid = Integer.parseInt(sFruitid);//类型转换
            FruitDAO fruitDAO = new FruitDAOImpl();
            if (fruitDAO.deleteFruit(fruitid)){
                response.sendRedirect("index.do");
            }else {
                DispatcherUtil.openErrWeb("商品删除失败", "editfruit.do?fruitid=" + fruitid, request, response);
                return;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}