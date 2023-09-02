package com.thw.system.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
//    private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
//    private static final String DB_URL = "jdbc:mariadb://airspirk.asuscomm.com:43306/university";
//    private static final String DB_USERNAME = "root";
//    private static final String DB_PW = "root";

    public static Connection getConnection(){
        Connection conn = null;
        try{
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
//            Class.forName(DB_DRIVER_CLASS);

            conn = DriverManager.getConnection
                    ("jdbc:mariadb://airspirk.asuscomm.com:43306/university","root","root");
            if(conn != null){
                System.out.println("DB Connect success");
            }
        } catch (SQLException e){
            System.out.println("DB connect is fail");
            e.printStackTrace();
        }

        return conn;
    }
}
