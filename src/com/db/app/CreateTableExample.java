package com.db.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateTableExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            Statement st = connection.createStatement();
            boolean result  = st.execute("create table testx(id int not null primary key)");
            // false states that does the execute have result or it void ?
            // execute will throw exception if it cannot execute
            // true and false is specifically to check the result set
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
