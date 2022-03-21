package com.manhattan.services.carDealer.implementations;

import com.manhattan.models.carDealer.entities.Customer;
import com.manhattan.repositories.carDealer.CustomerRepository;
import com.manhattan.services.carDealer.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(Iterable<Customer> customers) {
        this.repository.saveAllAndFlush(customers);
    }

    @Override
    public Customer getRandomCustomer() {
        return this.repository.getById(
                ThreadLocalRandom.current().nextLong(1L, this.repository.count() + 1));
    }
}
