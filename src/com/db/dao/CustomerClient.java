package com.db.dao;

public class CustomerClient {

    public static void main(String[] args) {
        IDAO dao = CustomerDAOFactory.getCustomerDAOFactory();
        Customer customer = new Customer();
        customer.setContactFirstName("xx");
        dao.create(customer);
        dao.delete(customer);
        dao.update(customer);
        dao.find(new Long(1));
    }
}
