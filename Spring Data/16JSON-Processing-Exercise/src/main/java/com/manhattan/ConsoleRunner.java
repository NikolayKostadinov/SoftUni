package com.manhattan;

import com.manhattan.models.productsShop.dtos.CategoriesByProductsDto;
import com.manhattan.models.productsShop.dtos.UserSoldDto;
import com.manhattan.models.productsShop.dtos.UsersAndProductsDto;
import com.manhattan.services.carDealer.interfaces.SeedCarDealerService;
import com.manhattan.services.carDealer.interfaces.SupplierService;
import com.manhattan.services.common.FileService;
import com.manhattan.services.productShop.interfaces.CategoryService;
import com.manhattan.services.productShop.interfaces.ProductService;
import com.manhattan.services.productShop.interfaces.SeedProductShopService;
import com.manhattan.services.productShop.interfaces.UserService;
import com.manhattan.utils.ConsoleService;
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
    private final SeedProductShopService seedProductShopService;
    private final SeedCarDealerService seedCarDealerService;
    private final FileService fileService;
    private final SupplierService supplierService;
    private final ConsoleService console;

    public ConsoleRunner(UserService userService,
                         ProductService productService,
                         CategoryService categoryService,
                         SeedProductShopService seedService,
                         SeedCarDealerService seedCarDealerService,
                         FileService fileService,
                         SupplierService supplierService, ConsoleService console) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.seedProductShopService = seedService;
        this.seedCarDealerService = seedCarDealerService;
        this.fileService = fileService;
        this.supplierService = supplierService;
        this.console = console;
    }

    @Override
    public void run(String... args) throws Exception {
        // 2.	Seed the Database
        console.printInfoMessage("Seeding ProductShop...");
        seedProductShopData();
        // 3.	Query and Export Data
        // Query 1 – Products in Range
        console.printInfoMessage(String.format("Generating {%s} ...", PRODUCTS_IN_RANGE_FILE));
        saveAllProductsInRange();

        // Query 2 – Successfully Sold Products
        console.printInfoMessage(String.format("Generating {%s} ...", USERS_SOLD_FILE));
        successfullySoldProducts();

        // Query 3 – Categories by Products Count
        console.printInfoMessage(String.format("Generating {%s} ...", CATEGORIES_BY_PRODUCTS_FILE));
        categoriesByProductsCount();

        // Query 4 – Users and Products
        console.printInfoMessage(String.format("Generating {%s} ...", USERS_AND_PRODUCTS_FILE));
        usersAndProducts();

        // 5. Car Dealer Import Data
        console.printInfoMessage("Seeding CarDealer...");
        seedCarDealerData();

    }

    private void seedCarDealerData() throws IOException {
        if (this.supplierService.hasNoRecords())
            this.seedCarDealerService.seed();
    }

    private void usersAndProducts() throws IOException {
        UsersAndProductsDto users = this.userService.getAllUsersWithMoreThanOneSoldProductsOrderByProductSoldDescThenByLastName();
        this.fileService.writeToFile(OUTPUT_FILE_PATH + USERS_AND_PRODUCTS_FILE, users);
    }

    private void categoriesByProductsCount() throws IOException {
        List<CategoriesByProductsDto> categories = this.categoryService.getCategoriesOrderByNumberOfProducts();
        this.fileService.writeToFile(OUTPUT_FILE_PATH + CATEGORIES_BY_PRODUCTS_FILE, categories);
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

    private void seedProductShopData() throws IOException {
        if (this.productService.hasNoRecords())
            this.seedProductShopService.seed();
    }
}
