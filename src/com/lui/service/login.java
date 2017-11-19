package com.lui.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lui.conn.conn;
/**
 * Created by lui on 2017/11/3.
 */
public class login {
    private Connection conn;
    private PreparedStatement pstmt;
    public login(){
        conn = new conn().getConn();
    }
    public boolean validLogin(String userName,String userPassword){
        try {
            pstmt = conn.prepareStatement("SELECT * FROM login WHERE userName = ? AND userPassword = ?");
            pstmt.setString(1,userName);
            pstmt.setString(2,userPassword);
            ResultSet re = pstmt.executeQuery();
            if(re.next()){
                return true;
            }
            else {
                return false;

            }
        }
        catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args){
        System.out.print(new login().validLogin("11","11"));
    }
}
