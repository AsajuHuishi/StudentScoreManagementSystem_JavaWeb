package indi.huishi.dao.impl;

import indi.huishi.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

//复用代码类 一般是抽象的
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 增删改
     * @return
     */
    public int update(String sql,Object ... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.update(connection,sql,args);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            JdbcUtils.close(connection);
        }
    }

    /*** 查询返回一个 javaBean 的 sql 语句 **
     * @param type 返回的对象类型 *
     * @param sql 执行的 sql 语句 *
     * @param args sql 对应的参数值 *
     * @param <T> 返回的类型的泛型 *
     * @return */
    public <T> Object queryForOne(Class<T> type, String sql, Object ... args){
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(connection);
        }
    }

    /**
     * 返回多个对象
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */

    public <T> List<T> queryForMulti(Class<T> type, String sql, Object ... args){
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(connection);
        }
    }

    /**
     * 返回一行一列
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object ... args){
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(connection);
        }
    }

    /**
     * shizuo,分组统计
     * @param sql
     * @param args
     * @return
     */
    public List<Map<String, Object>> queryForMapList(String sql, Object ... args){
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new MapListHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(connection);
        }
    }
}
