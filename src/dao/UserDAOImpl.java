package dao;

import model.TUser;
import utils.DataUtil;
import utils.IDataUtil;

import java.sql.ResultSet;

/**
 * 用户管理业务实现子类
 */

public class UserDAOImpl implements UserDAO{
    private IDataUtil dataUtil = null;// 数据库操作工具类

    public UserDAOImpl(){
        dataUtil = new DataUtil();
    }


    /**
     * 添加一个新用户
     *
     * @param user 受影响信息
     * @return 成功返回1，失败返回0
     */
    @Override
    public boolean addUser(TUser user) {
        String sql = "INSERT INTO t_user (userid, password, username, phone, rolecode, rolename) " +
                "VALUES(?,?,?,?,?,?)";
        Object[] para = {user.getUserid(), user.getPassword(),
                user.getUsername(), user.getPhone(),
                user.getRolecode(), user.getRolename()};
        if (dataUtil.insert(sql,para) > 0)
            return true;
        else
            return false;

    }

    /**
     * 修改一个存在的用户信息
     *
     * @param user 受影响信息
     * @return 成功返回true，失败返回false
     */
    @Override
    public boolean updateUser(TUser user) {
        String sql = "UPDATE t_user SET password=?, username=?, phone=?, rolecode=?, rolename=? " +
                "WHERE userid=?";
        Object[] para = {user.getPassword(), user.getUsername(), user.getPhone(),
                user.getRolecode(), user.getRolename(), user.getUserid()};
        if (dataUtil.update(sql,para) > 0)
            return true;
        else
            return false;
    }

    /**
     * 删除用户信息
     *
     * @param userid
     * @return 成功返回true，失败返回false
     */
    @Override
    public boolean deleteUser(String userid) {
        String sql = "DELETE FROM t_user WHERE userid=?";
        Object[] para = {userid};
        if (dataUtil.delete(sql,para) > 0)
            return true;
        else
            return false;
    }

    /**
     * 根据账号(userid)和密码(password)进行用户身份的验证，成功返回TUser对象
     *
     * @param userid   用户账号
     * @param password 密码
     * @return 成功则返回TUser对象，失败返回null或TUser
     */
    @Override
    public TUser login(String userid, String password) {
        String sql = "SELECT * FROM t_user WHERE userid=? AND password=?";
        Object[] para = {userid,password};
        ResultSet rs = dataUtil.select(sql,para);
        TUser user = new TUser(rs);//构造唯一user对象
        dataUtil.close();//凡是查询都必须关闭资源
        return user;
    }

    /**
     * 根据userid查询并返回一个user对象
     *
     * @param userid 用户账号
     * @return 成功则返回TUser对象，失败返回null或TUser
     */
    @Override
    public TUser getUserById(String userid) {
        String sql = "SELECT * FROM t_user WHERE userid=?";
        Object[] para = {userid};
        ResultSet rs = dataUtil.select(sql,para);
        TUser user = new TUser(rs);//构造唯一user对象
        dataUtil.close();//凡是查询都必须关闭资源
        return user;
    }
}
