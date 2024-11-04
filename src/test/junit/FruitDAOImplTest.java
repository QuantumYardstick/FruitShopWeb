package test.junit;

import dao.FruitDAO;
import dao.FruitDAOImpl;
import model.TFruit;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FruitDAOImplTest {
    private final FruitDAO fruitDAO = new FruitDAOImpl();



    @Test
    public void addFruit() {
        TFruit fruit = new TFruit();
        fruit.setFruitname("测试");
        fruit.setProducer("测试");
        fruit.setPrice(0);
        fruit.setCount(0);
        fruit.setImgs("测试");
        System.out.println("key="+fruitDAO.addFruit(fruit));
    }

    @Test
    public void updateFruit() {
        //修改需要先查询，再修改
        TFruit fruit = fruitDAO.getFruitById(22);
        fruit.setFruitname("水果测试");
        fruit.setProducer("产地测试");
        fruit.setPrice(20.1);
        fruit.setCount(100);
        fruit.setImgs("图片测试");
        System.out.println(fruitDAO.updateFruit(fruit));
    }

    @Test
    public void deleteFruit() {
        System.out.println(fruitDAO.deleteFruit(22));
    }

    @Test
    public void getFruitById() {
        TFruit fruit = fruitDAO.getFruitById(1);
        System.out.println(fruit);
    }

    @Test
    public void getFruitByName() {
        //无数据进行无条件查询
        List<TFruit> list = fruitDAO.getFruitByName(null);
//        System.out.println(list);

        System.out.println("\n");

        //有数据进行模糊查询
//        List<TFruit> list1 = fruitDAO.getFruitByName("果");
        System.out.println(list);

    }
}