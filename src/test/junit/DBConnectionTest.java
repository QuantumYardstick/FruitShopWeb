package test.junit;

import dbc.DBConnection;
import org.junit.Test;

import java.sql.Connection;

public class DBConnectionTest {

    @Test
    public void getConnectio() throws Exception {

        // 创建一个新的DBConnection对象，该对象通常用于管理数据库连接
        DBConnection dbConnection = new DBConnection();

        // 使用DBConnection对象的getConnection方法获取数据库连接
        Connection connection = dbConnection.getConnection();

        // 如果程序执行到此处，说明数据库连接已经成功建立，打印一条消息表示连接成功
        System.out.println("水果店在线营销网站数据库连接建立成功");

        // 使用DBConnection对象的closeConnection方法关闭数据库连接，传入connection参数表示要关闭的连接，
        // 其余两个null参数可能代表预编译的Statement和结果集，这里假设它们不需要关闭
        dbConnection.closeConnection(connection, null, null);
    }
}
