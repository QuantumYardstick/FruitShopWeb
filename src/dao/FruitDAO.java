package dao;

/**
 * 商城信息管理业务类接口
 */

import model.*;
import java.util.List;

public interface FruitDAO {
    /**
     *  添加一个水果产品
     * @param fruit 受影响信息
     * @return 成功返回主键，失败返回0
     */
    public int addFruit(TFruit fruit);

    /**
     * 修改一个存在的水果产品信息
     * @param fruit 受影响信息
     * @return 成功返回true，失败返回false
     */
    public boolean updateFruit(TFruit fruit);

    /**
     * 根据水果ID删除水果产品
     * @param fruitid 水果ID
     * @return 成功返回true，失败返回false
     */
    public boolean deleteFruit(int fruitid);

    /**
     * 根据水果产品ID查询水果
     * @param fruitid
     * @return
     */
    public TFruit getFruitById(int fruitid);

    /**
     * 根据水果商品的关键字查询水果产品，当关键字为null或""，返回所有电脑商品
     * @param name
     * @return
     */
    public List<TFruit> getFruitByName(String name);

}
