package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 网站用户信息表实体类：对应t_user表
 */

public class TUser {
    private String userid; // 用户ID
    private String password; // 密码
    private String username; // 用户名
    private String phone; // 手机号
    private int rolecode; // 角色代码
    private String rolename; // 角色名称

    /**
     * 无参构造方法
     */
    public TUser() {
    }

    /**
     * 有参构造方法
     * @param userid
     * @param password
     * @param username
     * @param phone
     * @param rolecode
     * @param rolename
     */
    public TUser(String userid, String password, String username,
                 String phone, int rolecode, String rolename) {
        this.userid = userid;
        this.password = password;
        this.username = username;
        this.phone = phone;
        this.rolecode = rolecode;
        this.rolename = rolename;
    }

    /**
     * 设置或获取各字段名信息
     */
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRolecode() {
        return rolecode;
    }

    public void setRolecode(int rolecode) {
        this.rolecode = rolecode;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * 重写to String方法
     */
    @Override
    public String toString() {
        return "TUser{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", rolecode=" + rolecode +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    //单个表记录的实体类数据交换
    public TUser(ResultSet rs){
        try {
            if (rs != null && rs.next()){
                this.userid = rs.getString("userid");
                this.password = rs.getString("password");
                this.username = rs.getString("username");
                this.phone = rs.getString("phone");
                this.rolecode = rs.getInt("rolecode");
                this.rolename = rs.getString("rolename");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //多个表记录的实体数据交换
    public static List<TUser> tranList(ResultSet rs){
        //创建一个空的集合对象
        List<TUser> list = new ArrayList<TUser>();
        try {
            while (rs != null && rs.next()){
                TUser user = new TUser();
                user.userid = rs.getString("userid");
                user.password = rs.getString("password");
                user.username = rs.getString("username");
                user.phone = rs.getString("phone");
                user.rolecode = rs.getInt("rolecode");
                user.rolename = rs.getString("rolename");
                list.add(user);//把数据交换生成后的user对象添加到集合中
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;//返回集合对象
    }

}
