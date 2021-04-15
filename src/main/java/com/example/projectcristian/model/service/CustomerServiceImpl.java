package com.example.projectcristian.model.service;

import com.example.projectcristian.model.entity.Customer;
import com.example.projectcristian.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements ICustomerServicer{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Map<String, Object> getCustomer(Long id) {

        Map<String, Object> response = new LinkedHashMap<>();

        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null){
            response.put("message", "El cliente con el id " + id + " no existe en BBDD!");
            response.put("HttpStatus", 400);
            return response;
        }

        response.put("customer", customer);

        return response;
    }

    @Override
    public Map<String, Object> saveCustomer(Customer customer) {

        Map<String, Object> response = new LinkedHashMap<>();

        try {

            customerRepository.save(customer);

        }catch (DataAccessException e){
            response.put("message", "Error al insertar el registro!");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return response;
        }

        response.put("message", "El Registro se ha insertado con éxito!");

        return response;
    }
}
