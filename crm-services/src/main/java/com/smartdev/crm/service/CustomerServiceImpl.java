package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.CustomerRepository;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customer.setIsDelete(0);
        saveCustomer(customer);
    }
    @Override
    public Customer afindOneid(Integer id){
        return customerRepository.findOne(id);
    }

    @Override
    public List<Customer> findByuserBySeller(User user) {
        return customerRepository.findByUserBySeller(user);
    }


}

