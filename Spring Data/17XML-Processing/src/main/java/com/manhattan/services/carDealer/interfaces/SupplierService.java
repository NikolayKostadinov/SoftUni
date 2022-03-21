package com.manhattan.services.carDealer.interfaces;

import com.manhattan.models.carDealer.entities.Supplier;

public interface SupplierService {
    void saveAll(Iterable<Supplier> suppliers);
    boolean hasNoRecords();
    Supplier getRandomSupplier();
}
