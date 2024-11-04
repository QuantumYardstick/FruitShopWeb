package dbc;

import java.sql.*;

/**
 * 数据库连接类，用于提供数据库的连接和关闭操作
 */
public class DBConnection {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/fruitdb?" +
            "serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8";
    private String userName = "root";
    private String pwd = "root";

    /**
     * 根据DBConnection中定义的数据库连接参数，建立一个数据库连接，并返回连接对象
     * @return Connection
     */
    public Connection getConnection() throws Exception {
        //（1）加载驱动程序
        Class.forName(driverName);
        //(2)连接数据库，并返回一个Connection连接对象
        Connection conn = DriverManager.getConnection(url,userName,pwd);
        //System.out.println("数据库连接成功");
        return conn;
    }

    /**
     * 提供关闭参数中提供Connection,Statement,ResultSet对象
     * @param conn
     * @param stmt
     * @param rs
     */
    public void closeConnection(Connection conn, Statement stmt, ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace(); //打印由系统提供的异常信息说明
        }
    }
}
