package _04HospitalDatabase;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class _04Main {
    public static void main(String[] args) {
        EntityManager dbManager =
                Persistence.createEntityManagerFactory("codeFirstDb")
                        .createEntityManager();
    }
}
