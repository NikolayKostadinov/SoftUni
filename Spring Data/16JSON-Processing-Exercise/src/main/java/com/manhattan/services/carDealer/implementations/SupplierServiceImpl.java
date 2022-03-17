package com.manhattan.services.carDealer.implementations;

import com.manhattan.models.carDealer.entities.Supplier;
import com.manhattan.services.carDealer.SupplierRepository;
import com.manhattan.services.carDealer.interfaces.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository repository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(Iterable<Supplier> suppliers) {
        this.repository.saveAll(suppliers);
    }

    @Override
    public boolean hasNoRecords() {
        return this.repository.count() == 0;
    }

    @Override
    public Supplier getRandomSupplier() {
        long randomId = ThreadLocalRandom
                .current()
                .nextLong(1, this.repository.count() + 1);
        return this.repository.getById(randomId);
    }
}
