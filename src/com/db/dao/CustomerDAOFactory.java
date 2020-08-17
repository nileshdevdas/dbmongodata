package com.db.dao;

public class CustomerDAOFactory {


    public static IDAO getCustomerDAOFactory(){
        return new CustomerDAOMySQLImpl();
    }
}
