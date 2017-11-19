package com.lui.service;

import com.lui.conn.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lui on 2017/11/3.
 */
public class getArticle {
    Connection conn;
    PreparedStatement pstmt;
    public getArticle(){
        conn = new conn().getConn();
    }
    public List articleData(){
        List data = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM announces");
            ResultSet re = pstmt.executeQuery();
            while(re.next()){
                List oneRow = new ArrayList<>();
                oneRow.add(re.getInt(1));
//                System.out.print(re.getInt(1));
                oneRow.add(re.getString("userName"));
                oneRow.add(re.getString("topic"));
                oneRow.add(re.getString("announcesBody"));
                oneRow.add(re.getTimestamp("announcesTime"));
                oneRow.add(re.getInt("announcesState"));
                oneRow.add(re.getInt("announcesClass"));
                data.add(oneRow);
            }
            return data;
        }
        catch (Exception e){
            System.out.print("111");
            return null;
        }
    }

    public static void main(String[] args){
        List aaa = new getArticle().articleData();
        System.out.print(aaa.get(1));
    }
}
