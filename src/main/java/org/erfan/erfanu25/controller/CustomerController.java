package org.erfan.erfanu25.controller;

import org.erfan.erfanu25.model.Customer;
import org.erfan.erfanu25.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CustomerController {

//    private CustomerService customerService;
//
//    public CustomerController(CustomerService customerService){
//        this.customerService = customerService;
//    }

//    @Resource
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customer")
    public List<Customer> customer() {

        return customerService.getCustomer();
    }

//    ResponseEntity<String> hello() {
//        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
//    }
}
