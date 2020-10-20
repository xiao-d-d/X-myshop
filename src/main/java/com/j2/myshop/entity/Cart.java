package com.j2.myshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 数据库对应的购物车表
 */
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    private int cid;//购物车的唯一标识
    private int uid;//用户实体的主键属性
    private int pid;//商品的唯一主键
    private int cnum = 0;  //购车商品数量
    private BigDecimal ccount; //购物车小计
    private com.j2.myshop.entity.Product product;

    public Cart() {
    }

    public com.j2.myshop.entity.Product getProduct() {
        return product;
    }

    public void setProduct(com.j2.myshop.entity.Product product) {
        this.product = product;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", cnum=" + cnum +
                ", ccount=" + ccount +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public BigDecimal getCcount() {

        BigDecimal pprice = product.getPprice();
        BigDecimal bigDecimal = new BigDecimal(cnum);

        return pprice.multiply(bigDecimal);
    }

    public void setCcount(BigDecimal ccount) {
        this.ccount = ccount;
    }
}
