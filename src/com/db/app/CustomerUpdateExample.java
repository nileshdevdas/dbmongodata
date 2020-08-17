package com.db.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerUpdateExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            Statement st = connection.createStatement();
            int  rowsaffected  = st.executeUpdate(
                    "update customers set creditLimit = 70000 where customerNumber = 129"
            );
            System.out.println(rowsaffected);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if ((connection != null) && (!connection.isClosed())) {
                    connection.close();
                }
            } catch (Exception exception) {
            }
        }

    }


}
