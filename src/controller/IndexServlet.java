package controller;

/**
 * index主页的数据加载动作控制器
 */

import dao.FruitDAO;
import dao.FruitDAOImpl;
import model.TFruit;
import utils.DispatcherUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/index.do")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取关键字获取所有水果信息
        //修改字符集
        request.setCharacterEncoding("utf-8");

        String keytopic = request.getParameter("keytopic");

        // 创建FruitDAO对象
        FruitDAO fruitDAO = new FruitDAOImpl();

        System.out.println(keytopic);

        // 调用FruitDAO的getFruitByName方法根据关键字查询水果列表
        List<TFruit> list = fruitDAO.getFruitByName(keytopic);

        // 将查询结果保存到request作用域中，以便在JSP页面中使用
        request.setAttribute("fruitList", list);

        // 使用DispatcherUtil工具类打开index.jsp页面，并将request和response对象传递给它
        DispatcherUtil.openWeb("index.jsp", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 当以POST方式访问时，调用doGet方法处理请求
        doGet(request, response);
    }
}