package com.example.projectcristian.controller;

import com.example.projectcristian.model.entity.Customer;
import com.example.projectcristian.model.service.ICustomerServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(value = {})
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private ICustomerServicer customerServicer;

    @Autowired
    public CustomerController(ICustomerServicer customerServicer) {
        this.customerServicer = customerServicer;
    }

    @PostMapping("")
    public ResponseEntity<?> getCustomer(@Valid @RequestBody Customer customer, BindingResult result){

        Map<String, Object> response = new LinkedHashMap<>();

        if (result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("error", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        response = customerServicer.saveCustomer(customer);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
