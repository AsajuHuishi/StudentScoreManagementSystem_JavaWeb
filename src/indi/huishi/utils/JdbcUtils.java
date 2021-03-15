package indi.huishi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 功能：封装数据库的连接与关闭。 使用德鲁伊数据库连接池
 * @author AsajuHuishi
 *
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;
    static{
        try {
            Properties properties = new Properties();
//            properties.load(new FileInputStream("src\\jdbc.properties"));
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
//            System.out.println(properties);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 建立连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    /**
     * 关闭
     * @param connection
     */
    public static void close(Connection connection){//通用 因为使用DBUtils，不需要resultset和statement
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

