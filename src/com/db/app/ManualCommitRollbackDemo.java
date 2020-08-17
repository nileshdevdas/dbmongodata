package com.db.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManualCommitRollbackDemo {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            // the moment i do  autocommit to false any update, delete , insert action will not be commited
            // in the data
            // the autocommit controls who will decide all is well ?
            connection.setAutoCommit(false);
            PreparedStatement  ps = connection.prepareStatement("update customers set creditLimit = ? where customerNumber = ? ");
            ps.setInt(1, 17000 );
            ps.setInt(2, 103);
            ps.executeUpdate();
            // this is to harden
            // this line says all is well
            connection.commit();
            // you were inserting data in orders
            // when you tried payment it failed
            // sorry oops not well
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
