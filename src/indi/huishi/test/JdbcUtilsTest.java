package indi.huishi.test;

import indi.huishi.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbc() throws Exception {
        for(int i=0; i<20; i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
        System.out.println("开始");
    }

}
