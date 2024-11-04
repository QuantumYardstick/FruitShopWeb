package test.junit;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.TUser;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOImplTest {
    private UserDAO userDAO = new UserDAOImpl();

    @Test
    public void addUser() {
        TUser user = new TUser();
        user.setUserid("1");
        user.setPassword("测试");
        user.setUsername("测试");
        user.setPhone("测试");
        user.setRolecode(2);
        user.setRolename("网站用户");
        System.out.println(userDAO.addUser(user));
    }

    @Test
    public void updateUser() {
        //修改需要先查询，再修改
        TUser user = userDAO.getUserById("测试");
        user.setUserid("账号测试");
        user.setPassword("密码测试");
        user.setUsername("昵称测试");
        user.setPhone("手机号测试");
        user.setRolecode(3);
        user.setRolename("网站用户测试");
        user.setUserid("1");
        System.out.println(userDAO.updateUser(user));

    }

    @Test
    public void deleteUser() {
        System.out.println(userDAO.deleteUser("1"));
    }

    @Test
    public void login() {
        TUser loginUser = userDAO.login("admin","admin");
        System.out.println(loginUser);
    }

    @Test
    public void getUserById() {
        TUser user = userDAO.getUserById("admin");
        System.out.println(user);
    }
}