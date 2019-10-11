package com.dao;

import org.springframework.stereotype.Repository;

/**
 * @author : 赵静超
 * @date : 2019/10/10 14:04
 * @description :
 */
@Repository
@SuppressWarnings("all")
public class BookDao {

    private String lable;

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
