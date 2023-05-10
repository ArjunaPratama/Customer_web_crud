package com.arjuna.Costumer.Customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public Long countById(Long id);
}
