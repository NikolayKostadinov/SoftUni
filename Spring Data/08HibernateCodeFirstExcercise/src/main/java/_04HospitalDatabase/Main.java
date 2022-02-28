package _04HospitalDatabase;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager dbManager =
                Persistence.createEntityManagerFactory("salesDb")
                        .createEntityManager();
    }
}
