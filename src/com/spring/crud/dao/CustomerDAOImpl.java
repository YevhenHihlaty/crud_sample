package com.spring.crud.dao;

import com.spring.crud.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.query.Query;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers()
    {
        return sessionFactory.getCurrentSession().createQuery("from Customer order by lastName", Customer.class).getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
       sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete  from Customer " +
                        "where id=:customerId")
                .setParameter("customerId", id)
                .executeUpdate();
    }

    @Override
    public Customer getCustomer(int id) {
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }
}
