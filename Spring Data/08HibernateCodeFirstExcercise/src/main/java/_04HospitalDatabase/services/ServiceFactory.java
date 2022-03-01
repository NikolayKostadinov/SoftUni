package _04HospitalDatabase.services;

import _04HospitalDatabase.entities.Medicament;
import _04HospitalDatabase.repository.AddressRepositoryImpl;
import _04HospitalDatabase.repository.MedicamentRepositoryImpl;
import _04HospitalDatabase.repository.PatientRepositoryImpl;
import _04HospitalDatabase.repository.TownRepositoryImpl;

import javax.persistence.EntityManager;

public class ServiceFactory {
    private final EntityManager em;
    private final TownServiceImpl townService;
    private final AddressServiceImpl addressService;
    private final PatientServiceImpl patientService;
    private final MedicamentServiceImpl medicamentService;
    public ServiceFactory(EntityManager em) {
        this.em = em;
        TownRepositoryImpl townRepository = new TownRepositoryImpl(em);
        AddressRepositoryImpl addressRepository = new AddressRepositoryImpl(em);
        this.townService = new TownServiceImpl(townRepository);
        this.addressService = new AddressServiceImpl(addressRepository, townRepository);
        this.patientService = new PatientServiceImpl(new PatientRepositoryImpl(em), addressRepository);
        this.medicamentService = new MedicamentServiceImpl(new MedicamentRepositoryImpl(em));
    }

    public Service getService(int operation){
        return switch (operation){
            case 2, 7 -> this.townService;
            case 3, 8 -> this.addressService;
            case 4, 9 -> this.patientService;
            case 5, 10 -> this.medicamentService;

            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}
