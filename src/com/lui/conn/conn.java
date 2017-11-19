package com.lui.conn;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by lui on 2017/11/2.
 */
public class conn {
    public Connection getConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/BBS?useSSL=false&characterEncoding=UTF-8";
            String user="root";
            String password = "czx372511";
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String args[]){

    }
}
