package _04HospitalDatabase.services;

import _04HospitalDatabase.repository.AddressRepositoryImpl;
import _04HospitalDatabase.repository.TownRepositoryImpl;

import javax.persistence.EntityManager;

public class ServiceFactory {
    private final EntityManager em;
    private final TownServiceImpl townService;
    private final AddressServiceImpl addressService;
    public ServiceFactory(EntityManager em) {
        this.em = em;
        TownRepositoryImpl townRepository = new TownRepositoryImpl(em);
        this.townService = new TownServiceImpl(townRepository);
        this.addressService = new AddressServiceImpl(new AddressRepositoryImpl(em), townRepository);
    }

    public Service getService(int operation){
        return switch (operation){
            case 2, 7 -> this.townService;
            case 3, 8 -> this.addressService;

            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}
