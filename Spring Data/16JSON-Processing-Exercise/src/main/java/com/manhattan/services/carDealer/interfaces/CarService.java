package com.manhattan.services.carDealer.interfaces;

import com.manhattan.models.carDealer.entities.Car;

public interface CarService {
    void saveAll(Iterable<Car> cars);
}
