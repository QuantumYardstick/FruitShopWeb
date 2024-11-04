package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 网站水果信息的实体类：对应t_fruit表
 */

public class TFruit {
    //水果ID
    private int fruitid;
    //水果名称
    private String fruitname;
    //生产商
    private String producer;
    //价格
    private double price;
    //数量
    private int count;
    //图片路径
    private String imgs;

    /**
     * 无参构造方法
     */
    public TFruit() {
    }

    /**
     * 有参构造方法
     * @param fruitid
     * @param fruitname
     * @param producer
     * @param price
     * @param count
     * @param imgs
     */
    public TFruit(int fruitid, String fruitname, String producer,
                  double price, int count, String imgs) {
        this.fruitid = fruitid;
        this.fruitname = fruitname;
        this.producer = producer;
        this.price = price;
        this.count = count;
        this.imgs = imgs;
    }

    /**
     * 设置或获取各字段名信息
     */
    public int getFruitid() {
        return fruitid;
    }

    public void setFruitid(int fruitid) {
        this.fruitid = fruitid;
    }

    public String getFruitname() {
        return fruitname;
    }

    public void setFruitname(String fruitname) {
        this.fruitname = fruitname;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    /**
     * 重写to String方法
     */
    @Override
    public String toString() {
        return "TFruit{" +
                "fruitid=" + fruitid +
                ", fruitname='" + fruitname + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", imgs='" + imgs + '\'' +
                '}';
    }

    //单个表记录的实体类数据交换
    public TFruit(ResultSet rs){
        try{
            if (rs != null && rs.next()) {
                this.fruitid = rs.getInt("fruitid");
                this.fruitname = rs.getString("fruitname");
                this.producer = rs.getString("producer");
                this.price = rs.getDouble("price");
                this.count = rs.getInt("count");
                this.imgs = rs.getString("imgs");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 多个表记录的实体数据交换
    public static List<TFruit> tranList(ResultSet rs){
        List<TFruit> list = new ArrayList<TFruit>();
        try {


        while (rs != null && rs.next()){
            TFruit fruit = new TFruit();
            fruit.fruitid = rs.getInt("fruitid");
            fruit.fruitname = rs.getString("fruitname");
            fruit.producer = rs.getString("producer");
            fruit.price = rs.getDouble("price");
            fruit.count = rs.getInt("count");
            fruit.imgs = rs.getString("imgs");
            list.add(fruit);
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
