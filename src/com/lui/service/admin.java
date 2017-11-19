package com.lui.service;

import com.lui.conn.conn;
import javafx.beans.binding.StringBinding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lui on 2017/11/14.
 */
public class admin {
    Connection conn;
    PreparedStatement pstmt;
    public admin(){
        conn = conn = new conn().getConn();
    }
    public boolean adminLogin(String adminName,String adminPassword){

        boolean result = false;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM admin WHERE adminName = ? AND adminPassword = ?");
            pstmt.setString(1,adminName);
            pstmt.setString(2,adminPassword);
            ResultSet re = pstmt.executeQuery();
            if(re.next()){
                result = true;
            }
        }
        catch (Exception e){

        }
        return result;
    }

    public static void main(String[] args) {
        boolean aa = new admin().adminLogin("1234","123");
        System.out.print(aa);
    }
}
class Test {
    private static void test(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i] % 2 == 0) {
                    throw new NullPointerException();
                } else {
                    System.out.print(i);
                }
            } finally {
                System.out.print("e");
            }
        }
    }
    void aaa(StringBuilder aaa){
//        StringBuilder k = aaa;
        aaa.append("d");
    }

    public static void main(String[]args) {
        StringBuilder s1 = new StringBuilder("abc");
        new Test().aaa(s1);
        System.out.println(s1);
    }

}

class NameList
{
    private List names = new ArrayList();
    public synchronized void add(String name)
    {
        names.add(name);
    }
    public synchronized void printAll()     {
        for (int i = 0; i < names.size(); i++)
        {
            System.out.print(names.get(i) + " ");
        }
    }

    public static void main(String[]args)
    {
        final NameList sl = new NameList();
        for (int i = 0; i < 2; i++)
        {
            new Thread()
            {
                public void run()
                {
                    sl.add("A");
                    sl.add("B");
                    sl.add("C");
                    sl.printAll();
                }
            } .start();
        }
    }
}