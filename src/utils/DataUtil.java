package utils;

import dbc.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataUtil extends DBConnection implements IDataUtil {
    // 数据库连接对象
    private Connection conn = null;
    // 预编译SQL语句对象
    private PreparedStatement ptmt = null;
    // 调用存储过程的语句对象
    private CallableStatement ctmt = null;
    // 结果集对象
    private ResultSet rs = null;

    /**
     * 关闭数据库资源
     */
    @Override
    public void close() {
        if (ptmt != null) {
            this.closeConnection(conn, ptmt, rs);
        } else {
            this.closeConnection(conn, ctmt, rs);
        }
    }

    /**
     * 插入数据并返回受影响行数或主键值
     *
     * @param sql  SQL语句
     * @param para 参数数组
     * @return 受影响行数或主键值
     */
    @Override
    public int insert(String sql, Object[] para) {
        int rows = 0; // 受影响行数
        int key = 0; // 主键值
        try {
            conn = this.getConnection();
            ptmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); // 设置返回生成的主键
            // 动态设置SQL中的？参数实际值
            if (para != null) {
                for (int i = 1; i <= para.length; i++) {
                    ptmt.setObject(i, para[i - 1]);
                }
            }
            rows = ptmt.executeUpdate();
            if (rows > 0) {
                rs = ptmt.getGeneratedKeys(); // 成功后取主键值
                if (rs != null && rs.next()) {
                    key = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(); // 关闭数据库的所有资源对象
        }
        if (key > 0) return key; // 如果主键是自动编号，这返回主键值
        else return rows;
    }

    /**
     * 更新数据并返回受影响行数
     *
     * @param sql  SQL语句
     * @param para 参数数组
     * @return 受影响行数
     */
    @Override
    public int update(String sql, Object[] para) {
        int rows = 0;
        try {
            Connection conn = this.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql);
            // 设置SQL中？参数的实际值
            if (para != null) {
                for (int i = 1; i <= para.length; i++) {
                    ptmt.setObject(i, para[i - 1]);
                }
            }
            rows = ptmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return rows;
    }

    /**
     * 删除数据并返回受影响行数
     *
     * @param sql  SQL语句
     * @param para 参数数组
     * @return 受影响行数
     */
    @Override
    public int delete(String sql, Object[] para) {
        int rows = 0;
        try {
            Connection conn = this.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql);
            // 设置SQL中？参数的实际值
            if (para != null) {
                for (int i = 1; i <= para.length; i++) {
                    ptmt.setObject(i, para[i - 1]);
                }
            }
            rows = ptmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return rows;
    }

    /**
     * 查询数据并返回结果集
     *
     * @param sql  SQL语句
     * @param para 参数数组
     * @return 结果集
     */
    @Override
    public ResultSet select(String sql, Object[] para) {
        try {
            conn = this.getConnection();
            ptmt = conn.prepareStatement(sql
                    , ResultSet.TYPE_SCROLL_INSENSITIVE // 结果集双向移动
                    , ResultSet.CONCUR_READ_ONLY); // 只读模式
            if (para != null) {
                for (int i = 1; i <= para.length; i++) {
                    ptmt.setObject(i, para[i - 1]);
                }
            }
            rs = ptmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // this.close(); // 不能关闭数据库资源，否则rs会被销毁
        }
        return rs;
    }

    /**
     * 查询数据并返回总行数
     *
     * @param sql  SQL语句
     * @param para 参数数组
     * @return 总行数
     */
    @Override
    public int selectCount(String sql, Object[] para) {
        int totalRows = 0;
        try {
            conn = this.getConnection();
            ptmt = conn.prepareStatement(sql
                    , ResultSet.TYPE_SCROLL_INSENSITIVE // 结果集双向移动
                    , ResultSet.CONCUR_READ_ONLY); // 只读模式
            if (para != null) {
                for (int i = 1; i <= para.length; i++) {
                    ptmt.setObject(i, para[i - 1]);
                }
            }
            rs = ptmt.executeQuery();
            rs.last(); // 滚动到最后一行
            totalRows = rs.getRow(); // 取最后一行的行号
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(); // 不能关闭数据库资源，否则rs会被销毁
        }
        return totalRows;
    }

    /**
     * 调用存储过程并返回结果集
     *
     * @param procName 存储过程名称
     * @param para     参数数组
     * @return 结果集
     */
    @Override
    public ResultSet callProcedureWithQuery(String procName, Object[] para) {
        try {
            conn = this.getConnection();
            ctmt = conn.prepareCall("{ call " + procName + "}");
            if (para != null) {
                for (int i = 1; i < para.length; i++) {
                    ctmt.setObject(i, para[i - 1]);
                }
            }
            boolean flag = ctmt.execute(); // 执行存储过程的调用使用execute
            if (flag) { // 调用成功
                rs = ctmt.getResultSet();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // this.close();
        }
        return rs;
    }
}