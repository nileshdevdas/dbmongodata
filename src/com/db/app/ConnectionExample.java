package com.db.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select avg(creditLimit) as max_lim, customerName , city  from customers ");
            while (rs.next()) {
                System.out.println("Customer Name : " + rs.getString("customerName") + " , City : " + rs.getString("City") + " , Max Limit " + rs.getString("max_lim"));
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
