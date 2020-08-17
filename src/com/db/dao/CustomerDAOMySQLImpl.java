package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class CustomerDAOMySQLImpl implements  IDAO{

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private Connection getConnection()throws Exception{
        return DriverManager.getConnection("ur", "root", "");
    }

    @Override
    public void create(Customer customer) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into customers values (?,?,?,?)");
            ps.setLong(1, customer.getCustomerNumber());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getContactFirstName());
            ps.setString(3, customer.getContactFirstName());
            int result = ps.executeUpdate();
            if(result != 1){
                throw new RuntimeException("Failed to Create Customer");
            }
        }catch(Exception e){
            e.printStackTrace();;
        }
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public Customer find(Long customerid) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}