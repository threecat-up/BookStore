package com.yj.dao.impl;

import com.yj.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yj
 * @create 2020-08-21 11:32
 */
public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();
    /*
     *update()方法用来执行Insert\Update\Delete语句
     * @return 如果返回-1则失败，成功返回影响的行数
     */
    public int update(String sql,Object ... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     *查询返回一个Javabean的SQL语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     *查询返回多个Javabean的SQL语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql,Object ... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
