package _02SalesDatabase;

import _02SalesDatabase.entities.Customer;
import _02SalesDatabase.entities.Product;
import _02SalesDatabase.entities.Sale;
import _02SalesDatabase.entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class _02Main {
    public static void main(String[] args) {
        EntityManager dbManager =
                Persistence.createEntityManagerFactory("codeFirstDb")
                        .createEntityManager();


        dbManager.getTransaction().begin();

        Product product = new Product();
        product.setName("Socks");

        Customer customer = new Customer();
        customer.setName("Baj Ivan");
        customer.setEmail("bay_ivan@test.com");
        customer.setCreditCardNumber("1234567890");

        StoreLocation storeLocation = new StoreLocation();
        storeLocation.setLocationName("Pazara");



        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setCustomer(customer);
        sale.setStoreLocation(storeLocation);

        dbManager.persist(sale);

        dbManager.getTransaction().commit();

        dbManager.close();
    }
}
