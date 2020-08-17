package com.db.dao;

import java.util.List;

public interface IDAO {

    public void create(Customer customer);
    public void update(Customer customer);
    public void delete(Customer customer);
    public  Customer find(Long customerid);
    public List<Customer> findAll();
}
