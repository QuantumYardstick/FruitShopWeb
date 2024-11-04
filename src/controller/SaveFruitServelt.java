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
 * 保存商品信息的动作控制器
 */

@WebServlet(name = "SaveFruitServelt", value = "/savefruit.do")
public class SaveFruitServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义字符集
        request.setCharacterEncoding("utf-8");
        //接收参数，进行数据校验
        //获得fruitid
        String sFruitid = request.getParameter("fruitid");
        int fruitid = Integer.parseInt(sFruitid);//转换类型
        //获得fruitname
        String fruitname = request.getParameter("fruitname");
        //获得producer
        String producer = request.getParameter("producer");
        //获得price
        String dPrice = request.getParameter("price");
        double price = Double.parseDouble(dPrice);//转换类型
        //获得count
        String sCount = request.getParameter("count");
        int count = Integer.parseInt(sCount);
        //获得imgs
        String imgs = request.getParameter("imgs");

        //数据校验
        if (fruitname == null || fruitname.equals("")) {
            DispatcherUtil.openErrWeb("商品名不能为空", "editfruit.do?fruitid=" + fruitid, request, response);
            return;
        }

        if (producer == null || producer.equals("")) {
            DispatcherUtil.openErrWeb("商品产地不能为空", "editfruit.do?fruitid=" + fruitid, request, response);
            return;
        }

        // 实现数据的保存，根据结果进行页面的跳转
        // 数据的保存根据fruitid是否为0，分为新增和修改两种情况
        FruitDAO fruitDAO = new FruitDAOImpl();
        if (fruitid == 0){
            //新增水果
            TFruit fruit  = new TFruit();
            fruit.setFruitname(fruitname);
            fruit.setProducer(producer);
            fruit.setPrice(price);
            fruit.setCount(count);
            fruit.setImgs(imgs);
            if (fruitDAO.addFruit(fruit) >0){
                response.sendRedirect("index.do");
            }else {
                DispatcherUtil.openErrWeb("商品添加失败", "editfruit.do?fruitid=" + fruitid, request, response);

            }

        }else {
            //修改水果,先查出电脑商品对象
            TFruit fruit = fruitDAO.getFruitById(fruitid);
            fruit.setFruitname(fruitname);
            fruit.setProducer(producer);
            fruit.setPrice(price);
            fruit.setCount(count);
            fruit.setImgs(imgs);
            if (fruitDAO.updateFruit(fruit)){
                response.sendRedirect("index.do");
            }else {
                DispatcherUtil.openErrWeb("商品修改失败", "editfruit.do?fruitid=" + fruitid, request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
