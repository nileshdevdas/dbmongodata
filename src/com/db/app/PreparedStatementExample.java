package com.db.app;
import java.sql.*;
public class PreparedStatementExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            // the moment i do  autocommit to false any update, delete , insert action will not be commited
            // in the data
            connection.setAutoCommit(false);
            PreparedStatement  ps = connection.prepareStatement("select * from customers where customerName = ? and contactFirstname = ? ");
            ps.setString(1, "Atelier graphique");
            ps.setString(2, "Carine");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("city"));
            }
            // this is to harden
            connection.commit();
            // you were inserting data in orders
            // when you tried payment it failed
            connection.rollback();
            // database with jdbc support Atomicity and Atomic Transaction
            // you can begin the transaction by set AutoCommit to false
            // Where you feel you feel you needd to do the commit you can commit or if issue a rollback can
            // be invoked
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
