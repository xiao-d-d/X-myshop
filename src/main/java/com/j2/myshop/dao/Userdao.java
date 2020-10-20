package com.j2.myshop.dao;

import com.j2.myshop.entity.User;

import java.sql.SQLException;

public interface Userdao {
    User  selectUserByUname(String username) throws SQLException;

    int   insertUser(User user) throws SQLException;

    User selectUserByCode(String code) throws SQLException;

    int updateStatusByUid(int uid) throws SQLException;
}
