package org.erfan.appcentric.controller.customer;

import org.erfan.appcentric.domain.Customer;
import org.erfan.appcentric.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.delete(id);
    }

    @PostMapping("/customer")
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
        return ResponseEntity.ok(customerService.updateCustomer(customer,id));
    }

}
