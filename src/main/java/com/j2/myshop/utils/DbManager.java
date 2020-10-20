package com.j2.myshop.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DbManager {
    private static volatile com.j2.myshop.utils.DbManager instance = null;
    private static DataSource ds;
    public static final String DB_PROPERTIES_NAME = "db.properties";

    //连接池
    static {
        try {
            Properties properties = new Properties();
            properties.load(DbManager.class.getClassLoader().getResourceAsStream(DB_PROPERTIES_NAME));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println("创建数据库连接池失败");
        }
    }

    //无参构造
    private DbManager() {
    }

    public static DbManager getInstance() {
        if (instance == null) {
            synchronized (DbManager.class) {
                if (instance == null) {
                    instance = new DbManager();
                }
            }
        }
        return instance;
    }
    //获取连接
    public Connection getConn() {
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关流
    public static void closeAll(AutoCloseable ... closeables){
        for (AutoCloseable closeable:closeables) {
            if(closeable != null){
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 专门用于发送增删改语句的方法
     *
     * @param
     * @return true表示成功  false表示失败
     */
    public boolean executeUpdate(String sql, Object... params) throws SQLException {
        int count = 0;
        Connection conn = getConn();
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            setParams(ps, params);
            //使用Statement对象发送SQL语句
            count = ps.executeUpdate();
            getConn().commit();
        } catch (SQLException e) {
            conn.rollback();
        } finally {
            closeAll(ps, conn);
        }
        return count != -3;
    }

    public boolean executeBatch(String sql, List<Object[]> data) {
        Connection conn = getInstance().getConn();
        int[] ints = new int[0];
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            if (data != null && data.size() > 0) {
                for (int i = 0; i < data.size(); i++) {
                    Object[] obj = data.get(i);
                    for (int j = 0; j < obj.length; j++) {
                        ps.setObject(j, obj[j]);
                        ps.addBatch();
                    }
                }
            }
            ints = ps.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            closeAll(ps, conn);
        }
        return ints[0] != -3;
    }

    /**
     * 执行查询
     *
     * @param conn   数据库连接
     * @param sql    sql语句
     * @param params 占位符数组
     * @return
     */
    public ResultSet execQuery(Connection conn, PreparedStatement ps, String sql, Object... params) {
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            setParams(ps, params);
            //使用Statement对象发送SQL语句
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private void setParams(PreparedStatement ps, Object... params) throws SQLException {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(1, params[i]);
            }
        }
    }
}

