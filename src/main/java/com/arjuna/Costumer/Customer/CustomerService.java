package com.arjuna.Costumer.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired CustomerRepository customerRepository;

    public List<Customer> customerList(){
        return (List<Customer>) customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getId(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    public void deleteCustomer(Long id){
        Long count = customerRepository.countById(id);
        customerRepository.deleteById(id);
    }
}
