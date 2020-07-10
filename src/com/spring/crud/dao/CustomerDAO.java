package com.spring.crud.dao;

import com.spring.crud.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
    public void deleteCustomer(int id);
    public Customer getCustomer(int id);
}
