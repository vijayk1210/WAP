package com.mb.wapsanity.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static Connection startConnection() throws Exception {

        String url = "jdbc:db2://115.112.206.242:50000/MBLIVEDB";
        String driver = "com.ibm.db2.jcc.DB2Driver";
        String userName = "property";
        String password = "tpmbd@t@";

        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url, userName,password);

        return conn;
    }
    
    
    public static void closeConnection(Connection conn) {
        try {

            conn.close();

        } catch (Exception e) {

        }

    }
    
    
    
}