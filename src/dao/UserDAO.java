package dao;

import model.TUser;

/**
 * 用户管理业务类接口
 */

public interface UserDAO {
    /**
     * 添加一个新用户
     * @param user 受影响信息
     * @return 成功返回1，失败返回0
     */
     public boolean addUser(TUser user);

    /**
     * 修改一个存在的用户信息
     * @param user 受影响信息
     * @return 成功返回true，失败返回false
     */
    public boolean updateUser(TUser user);

    /**
     * 删除用户信息
     * @param userid
     * @return 成功返回true，失败返回false
     */
    public boolean deleteUser(String userid);

    /**
     * 根据账号(userid)和密码(password)进行用户身份的验证，成功返回TUser对象
     * @param userid 用户账号
     * @param password 密码
     * @return 成功则返回TUser对象，失败返回null或TUser
     */
    public TUser login(String userid, String password);

    /**
     * 根据userid查询并返回一个user对象
     * @param userid 用户账号
     * @return 成功则返回TUser对象，失败返回null或TUser
     */
    public TUser getUserById(String userid);

}
