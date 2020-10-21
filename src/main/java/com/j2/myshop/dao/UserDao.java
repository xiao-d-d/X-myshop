package com.j2.myshop.dao;

import com.j2.myshop.entity.User;

import java.sql.SQLException;

//负责用户模块数据库访问的接口
public interface UserDao {
    User selectUserByUname(String username) throws SQLException;
}
