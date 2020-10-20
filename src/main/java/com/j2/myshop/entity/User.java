package com.j2.myshop.entity;

public class User {
    private int uid;//用户实体的主键属性
    private String username;  //对应的是数据库的uname字段
    private String upassword; //密码
    private String usex; //性别
    private String ustatus; //用户的激活状态 0 未激活 1 激活

    private String code;//邮件激活码
    private String email; //对应的是数据库的uemail字段
    private int urole; //用户 0 管理员 1

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUrole() {
        return urole;
    }

    public void setUrole(int urole) {
        this.urole = urole;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", upassword='" + upassword + '\'' +
                ", usex='" + usex + '\'' +
                ", ustatus='" + ustatus + '\'' +
                ", code='" + code + '\'' +
                ", email='" + email + '\'' +
                ", urole=" + urole +
                '}';
    }
}
