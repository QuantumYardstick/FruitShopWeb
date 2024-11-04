package dao;

import model.TFruit;
import utils.DataUtil;
import utils.IDataUtil;

import java.sql.ResultSet;
import java.util.List;

/**
 * 水果商品管理业务子类
 */

public class FruitDAOImpl implements FruitDAO{
    private IDataUtil dataUtil = null;//

    public FruitDAOImpl(){
        dataUtil = new DataUtil();
    }


    /**
     * 添加一个水果产品
     *
     * @param fruit 受影响信息
     * @return 成功返回主键，失败返回0
     */
    @Override
    public int addFruit(TFruit fruit) {
        String sql = "INSERT INTO t_fruit (fruitname, producer, price, count, imgs) " +
                " VALUES(?,?,?,?,?)";
        Object[] para = {fruit.getFruitname(), fruit.getProducer(),
                fruit.getPrice(), fruit.getCount(), fruit.getImgs()};

        return dataUtil.insert(sql,para);
    }

    /**
     * 修改一个存在的水果产品信息
     *
     * @param fruit
     * @return 成功返回true，失败返回false
     */
    @Override
    public boolean updateFruit(TFruit fruit) {
        String sql = "UPDATE t_fruit SET fruitname=?, producer=?," +
                " price=?, count=?, imgs=? WHERE fruitid=?";
        Object[] para = {fruit.getFruitname(), fruit.getProducer(),
                fruit.getPrice(), fruit.getCount(),
                fruit.getImgs(), fruit.getFruitid()};
        if (dataUtil.update(sql,para) > 0)
            return true;
        else
            return false;

    }

    /**
     * 根据水果ID删除水果产品
     *
     * @param fruitid 水果ID
     * @return 成功返回true，失败返回false
     */
    @Override
    public boolean deleteFruit(int fruitid) {
        String sql = "DELETE FROM t_fruit WHERE fruitid=?";
        Object[] para = {fruitid};
        if (dataUtil.delete(sql,para) > 0)
            return true;
        else
            return false;
    }

    /**
     * 根据水果产品ID查询水果
     *
     * @param fruitid
     * @return fruit
     */
    @Override
    public TFruit getFruitById(int fruitid) {
        String sql = "SELECT * FROM t_fruit WHERE fruitid=?";
        Object[] para = {fruitid};
        ResultSet rs = dataUtil.select(sql,para);
        TFruit fruit = new TFruit(rs);
        dataUtil.close();
        return fruit;
    }

    /**
     * 根据水果商品的关键字查询水果产品，当关键字为null或""，返回所有电脑商品
     *
     * @param name
     * @return list
     */
    @Override
    public List<TFruit> getFruitByName(String name) {
        ResultSet rs = null;
        if (name == null || name.equals("")){
            //为空无条件进行查询
            String sql = "SELECT * FROM t_fruit;";
            rs = dataUtil.select(sql,null);
        }else {
            //不为空模糊方式进行查询
            String sql = "SELECT * FROM t_fruit WHERE fruitname like ?";
            Object[] para = {"%" + name + "%"};
            rs = dataUtil.select(sql, para);
        }
        List<TFruit> list = TFruit.tranList(rs);
        dataUtil.close();//查询关闭资源
        return list;
    }
}
