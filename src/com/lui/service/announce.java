package com.lui.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import com.lui.conn.conn;

/**
 * Created by lui on 2017/11/5.
 */
public class announce {
    Connection conn;
    PreparedStatement pstmt;
    public announce(){
        conn = new conn().getConn();
    }
    public boolean announceResult(String userName, String topic,String announceBody,Timestamp time,int state,int Class){
        try {
            pstmt = conn.prepareStatement("INSERT INTO announces (userName,topic,announcesBody,announcesTime,announcesState,announcesClass) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1,userName);
            pstmt.setString(2,topic);
            pstmt.setString(3,announceBody);
            pstmt.setTimestamp(4,time);
            pstmt.setInt(5,state);
            pstmt.setInt(6,Class);
            pstmt.execute();
            return true;

        }
        catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) {
        String userName = "111";
        String topic = "hahah";
        String announceBody = "kkkppp";
        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.print(new announce().announceResult(userName,topic,announceBody,time,1,1));

    }
}
