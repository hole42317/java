package com.lui.service;

import com.lui.conn.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lui on 2017/11/4.
 */
public class getArticleBody {
    Connection conn;
    PreparedStatement pstmt;
    public getArticleBody(){
        conn = new conn().getConn();
    }
    public List articleBodyData(int aid){
        List articleBody = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM announces WHERE AID = ?");
            pstmt.setInt(1,aid);
            ResultSet re = pstmt.executeQuery();
            while (re.next()){
                List announceBody = new ArrayList<>();
                announceBody.add(re.getInt(1));//AID
                announceBody.add(re.getString(2));//userName
                announceBody.add(re.getDate(5));//time
                announceBody.add(re.getString(4));//body
                articleBody.add(announceBody);
//                announceBody.add(1);
            }//1楼

            pstmt = conn.prepareStatement("SELECT * FROM reply WHERE AID = ?");
            pstmt.setInt(1,aid);
            re = pstmt.executeQuery();
            while(re.next()){
                List singleArticleBody = new ArrayList<>();
                singleArticleBody.add(re.getInt(1));
                singleArticleBody.add(re.getString(2));
                singleArticleBody.add(re.getTimestamp(3));
                singleArticleBody.add(re.getString(4));
//                singleArticleBody.add(re.getInt(5));
                articleBody.add(singleArticleBody);
            }//后面的回复
            return articleBody;

        }
        catch (Exception e){
            System.out.print("2");
            return null;
        }


    }

    public static void main(String[] args){
//        System.out.print("111");
        System.out.print(new getArticleBody().articleBodyData(1));
    }
}
