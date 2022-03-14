package com.manhattan;

import com.manhattan.models.dtos.CategoriesByProductsDto;
import com.manhattan.models.dtos.UserSoldDto;
import com.manhattan.models.dtos.UsersAndProductsDto;
import com.manhattan.models.entities.Category;
import com.manhattan.models.entities.User;
import com.manhattan.services.interfaces.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.manhattan.utils.CommonConstants.*;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final SeedService seedService;
    private final FileService fileService;

    public ConsoleRunner(UserService userService, ProductService productService, CategoryService categoryService, SeedService seedService, FileService fileService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.seedService = seedService;
        this.fileService = fileService;
    }

    @Override
    public void run(String... args) throws Exception {
        // 2.	Seed the Database
        seedData();

        // 3.	Query and Export Data
        // Query 1 – Products in Range
        saveAllProductsInRange();

        // Query 2 – Successfully Sold Products
        successfullySoldProducts();

        // Query 3 – Categories by Products Count
        categoriesByProductsCount();

        // Query 4 – Users and Products
        usersAndProducts();


    }

    private void usersAndProducts() throws IOException {
        UsersAndProductsDto users = this.userService.getAllUsersWithMoreThanOneSoldProductsOrderByProductSoldDescThenByLastName();
        this.fileService.writeToFile(OUTPUT_FILE_PATH + USERS_AND_PRODUCTS, users);
    }

    private void categoriesByProductsCount() throws IOException {
        List<CategoriesByProductsDto> categories = this.categoryService.getCategoriesOrderByNumberOfProducts();
        this.fileService.writeToFile(OUTPUT_FILE_PATH + CATEGORIES_BY_PRODUCTS, categories);
    }

    private void successfullySoldProducts() throws IOException {
        List<UserSoldDto> users = this.userService.getAllUsersWithMoreThanOneSoldProducts();
        this.fileService.writeToFile(OUTPUT_FILE_PATH + USERS_SOLD_FILE, users);
    }

    private void saveAllProductsInRange() throws IOException {
        this.fileService.writeToFile(OUTPUT_FILE_PATH + PRODUCTS_IN_RANGE_FILE,
                this.productService
                        .getNotBoughtProductsWithPriceInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000)));
    }

    private void seedData() throws IOException {
        if (this.productService.hasNoRecords())
            this.seedService.seed();
    }
}
