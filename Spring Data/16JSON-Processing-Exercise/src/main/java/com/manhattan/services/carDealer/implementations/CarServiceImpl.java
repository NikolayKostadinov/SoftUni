package com.manhattan.services.carDealer.implementations;

import com.manhattan.models.carDealer.entities.Car;
import com.manhattan.repositories.carDealer.CarRepository;
import com.manhattan.services.carDealer.interfaces.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository repository;

    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(Iterable<Car> cars) {
        this.repository.saveAll(cars);
    }
}
