package com.ding.util;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;
//    用于获取数据库连接的规范接口。数据源

    static {

        try {
            Properties properties = new Properties();
            // 读取jdbc配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            dataSource  = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

            System.out.println(dataSource.getConnection());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
         获取数据库中的连接池
     */
    public static Connection getConnection(){
        Connection conn = null;
        // 获取数据库池中的连接,如返回null连接失败
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    /*
        关闭连接，放回数据库连接池
     */
    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//
//    }
}
