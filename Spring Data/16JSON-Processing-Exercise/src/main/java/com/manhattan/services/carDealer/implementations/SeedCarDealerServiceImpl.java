package com.manhattan.services.carDealer.implementations;

import com.manhattan.models.carDealer.dtos.CarJsonReadDto;
import com.manhattan.models.carDealer.dtos.PartsJsonReadDto;
import com.manhattan.models.carDealer.dtos.SuppliersJsonReadDto;
import com.manhattan.models.carDealer.entities.Car;
import com.manhattan.models.carDealer.entities.Part;
import com.manhattan.models.carDealer.entities.Supplier;
import com.manhattan.services.carDealer.interfaces.CarService;
import com.manhattan.services.carDealer.interfaces.PartsService;
import com.manhattan.services.carDealer.interfaces.SeedCarDealerService;
import com.manhattan.services.carDealer.interfaces.SupplierService;
import com.manhattan.services.common.FileService;
import com.manhattan.utils.ValidationsUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.manhattan.utils.CommonConstants.*;

@Service
public class SeedCarDealerServiceImpl implements SeedCarDealerService {
    private final SupplierService supplierService;
    private final PartsService partsService;
    private final CarService carService;

    private final ValidationsUtil validator;
    private final FileService fileService;
    private final ModelMapper modelMapper;

    public SeedCarDealerServiceImpl(SupplierService supplierService,
                                    PartsService partsService, CarService carService, ValidationsUtil validator,
                                    FileService fileService,
                                    ModelMapper modelMapper) {
        this.supplierService = supplierService;
        this.partsService = partsService;
        this.carService = carService;
        this.validator = validator;
        this.fileService = fileService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seed() throws IOException {
        seedSuppliers();
        seedParts();
        seedCars();
    }

    private void seedCars() throws IOException {
        this.carService.saveAll(
                Arrays.stream(fileService
                                .readFile(RESOURCE_FILE_PATH + CARS_FILE, CarJsonReadDto[].class))
                        .filter(validator::isValid)
                        .map(car -> modelMapper.map(car, Car.class))
                        .map(car -> {
                            car.setParts(partsService.getRandomParts());
                            return car;
                        })
                        .collect(Collectors.toList())
        );
    }

    private void seedParts() throws IOException {
        this.partsService.saveAll(
                Arrays.stream(fileService
                                .readFile(RESOURCE_FILE_PATH + PARTS_FILE, PartsJsonReadDto[].class))
                        .filter(validator::isValid)
                        .map(part -> modelMapper.map(part, Part.class))
                        .map(part -> {
                            part.setSupplier(supplierService.getRandomSupplier());
                            return part;
                        })
                        .collect(Collectors.toList())
        );
    }

    private void seedSuppliers() throws IOException {
        this.supplierService.saveAll(
                Arrays.stream(fileService
                                .readFile(RESOURCE_FILE_PATH + SUPPLIERS_FILE, SuppliersJsonReadDto[].class))
                        .filter(validator::isValid)
                        .map(supp -> modelMapper.map(supp, Supplier.class))
                        .collect(Collectors.toList())
        );
    }
}
