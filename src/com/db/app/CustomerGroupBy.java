package com.db.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerGroupBy {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            Statement st = connection.createStatement();
            /* */
            //Statement st1 = connection.createStatement();
            //st1.execute("set session sql_mode = ''");
            ResultSet rs =  st.executeQuery(
                    "select count(1), customerNumber from orders o  group by  o.customerNumber having count(1)>4  order by 1 desc;\n"
            );
            while(rs.next()){
                System.out.println("Query ...." + rs.getString(1));
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
