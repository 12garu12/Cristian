package com.example.projectcristian.model.service;

import com.example.projectcristian.model.entity.Customer;

import java.util.Map;

public interface ICustomerServicer {

    Map<String, Object> getCustomer(Long id);

    Map<String, Object> saveCustomer(Customer customer);

}
