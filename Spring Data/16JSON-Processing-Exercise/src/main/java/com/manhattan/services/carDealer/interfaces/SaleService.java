package com.manhattan.services.carDealer.interfaces;

import com.manhattan.models.carDealer.entities.Sale;

public interface SaleService {
    void saveAll(Iterable<Sale> sales);
}
