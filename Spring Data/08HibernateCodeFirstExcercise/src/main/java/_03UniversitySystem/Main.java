package _03UniversitySystem;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager dbManager =
                Persistence.createEntityManagerFactory("universityDb")
                        .createEntityManager();
    }
}
