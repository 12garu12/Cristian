package com.example.projectcristian.model.repository;

import com.example.projectcristian.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
