package com.j2.myshop.dao.impl;

import com.j2.myshop.dao.UserDao;
import com.j2.myshop.entity.User;
import com.j2.myshop.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

//数据库访问实现类
public class UserDaoImpl implements UserDao {
    @Override
    public User selectUserByUname(String username) throws SQLException {
        //1.创建一个QueryRunner对象
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        //2.执行sql语句
        String  sql = "select u_id as uid , u_name as username , u_password as upassword" +
                ", u_sex as usex , u_status as ustatus , u_code as code , u_email as email " +
                ", u_role as urole from user where u_name = ?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), username);

        return user;
    }
}
