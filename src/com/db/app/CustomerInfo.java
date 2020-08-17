package com.db.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerInfo {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from customers order by creditLimit desc, contactFirstName asc");
            while (rs.next()) {
                System.out.println(rs.getString("city"));
            }
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
