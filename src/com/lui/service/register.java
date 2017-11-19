package com.lui.service;

import com.lui.conn.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lui on 2017/11/6.
 */
public class register {
    Connection conn;
    PreparedStatement pstmt;
    public register(){
        conn = new conn().getConn();
    }
    public String registerResult(String userName,String userPassword){
        try {
            pstmt = conn.prepareStatement("SELECT * FROM login WHERE userName = ?");
            pstmt.setString(1,userName);
            ResultSet re = pstmt.executeQuery();
            pstmt.clearParameters();
            if(!re.next()){
                String sql1 = "INSERT INTO login (userName,userPassword) VALUES ('"+ userName +"','"+ userPassword +"');";
                String sql2 = "INSERT INTO user (userName) VALUES ('"+ userName +"');";
                pstmt.addBatch(sql1);
                pstmt.addBatch(sql2);
                pstmt.executeBatch();
                return "注册成功";
            }
            else {
                return "已存在";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "注册失败";
        }
    }

    public static void main(String[] args) {
        System.out.printf(new register().registerResult("11","11"));
    }
}
