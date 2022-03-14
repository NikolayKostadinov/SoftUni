package com.manhattan.services.implementations;

import com.manhattan.models.dtos.CategoryJsonReadDto;
import com.manhattan.models.dtos.ProductJsonReadDto;
import com.manhattan.models.dtos.UserJsonReadDto;
import com.manhattan.models.entities.Category;
import com.manhattan.models.entities.Product;
import com.manhattan.models.entities.User;
import com.manhattan.repositories.CategoryRepository;
import com.manhattan.repositories.ProductRepository;
import com.manhattan.repositories.UserRepository;
import com.manhattan.services.interfaces.*;
import com.manhattan.utils.ValidationsUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.manhattan.utils.CommonConstants.*;

@Service
public class SeedServiceImpl implements SeedService {
    private final FileService fileService;
    private final ValidationsUtil validator;
    private final ModelMapper modelMapper;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;

    public SeedServiceImpl(FileService fileService,
                           ValidationsUtil validator,
                           ModelMapper modelMapper,
                           ProductService productService,
                           UserService userService,
                           CategoryService categoryService) {
        this.fileService = fileService;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seed() throws IOException {
        seedCategories();
        seedUsers();
        seedProducts();
    }

    private void seedProducts() throws IOException {
        this.productService.saveAll(
                Arrays.stream(fileService
                                .readFile(RESOURCE_FILE_PATH + PRODUCTS_FILE, ProductJsonReadDto[].class))
                        .filter(validator::isValid)
                        .map(prod -> modelMapper.map(prod, Product.class))
                        .map(prod -> {
                            prod.setSeller(this.userService.getRandomUser());
                            if (prod.getPrice().compareTo(BigDecimal.valueOf(800L)) < 0) {
                                prod.setBuyer(this.userService.getRandomUser());
                            }
                            prod.setCategories(this.categoryService.getRandomCategories());
                            return prod;
                        })
                        .collect(Collectors.toList())
        );
    }

    private void seedUsers() throws IOException {
        this.userService.saveAll(
                Arrays.stream(fileService
                                .readFile(RESOURCE_FILE_PATH + USERS_FILE, UserJsonReadDto[].class))
                        .filter(validator::isValid)
                        .map(usr -> modelMapper.map(usr, User.class))
                        .collect(Collectors.toList())
        );
    }


    private void seedCategories() throws IOException {
        this.categoryService.saveAll(
                Arrays.stream(fileService
                                .readFile(RESOURCE_FILE_PATH + CATEGORIES_FILE, CategoryJsonReadDto[].class))
                        .filter(validator::isValid)
                        .map(cat -> modelMapper.map(cat, Category.class))
                        .collect(Collectors.toList())
        );
    }
}
