package com.lui.service;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

import com.lui.conn.conn;
/**
 * Created by lui on 2017/11/5.
 */
public class reply {
    private Connection conn;
    private PreparedStatement pstmt;
    public reply(){
        conn = new conn().getConn();
    }
    public boolean replyResult(int AID, String userName, Timestamp time, String reply){
        try{
            pstmt = conn.prepareStatement("INSERT INTO reply (AID,userName,replyTime,replyBody) VALUES (?,?,?,?)");
            pstmt.setInt(1,AID);
            pstmt.setString(2,userName);
            pstmt.setTimestamp(3,time);
            pstmt.setString(4,reply);
            pstmt.execute();
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }

    public static void main(String [] args){
        int AID = 2;
        String userName = "111";
        Timestamp time = new Timestamp(System.currentTimeMillis());
        String reply = "hhhhhhhh";
        System.out.print(new reply().replyResult(AID,userName,time,reply));
    }
}
