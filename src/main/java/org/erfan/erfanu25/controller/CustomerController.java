package org.erfan.erfanu25.controller;

import org.erfan.erfanu25.model.Customer;
import org.erfan.erfanu25.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/customr/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        if(!customer.isPresent()) {
            throw new ArithmeticException("Not Found");
        }
        return customer.get();
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.delete(id);
    }

    @PostMapping("/customer")
    public ResponseEntity<Object> createCustomer(@RequestBody  Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
        customerService.updateCustomer(customer,id);
        return ResponseEntity.noContent().build();
    }



//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public customer() {
//
//    }

//    ResponseEntity<String> hello() {
//        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
//    }
}
