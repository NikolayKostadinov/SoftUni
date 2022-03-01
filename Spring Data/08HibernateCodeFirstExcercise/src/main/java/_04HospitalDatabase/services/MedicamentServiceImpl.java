package _04HospitalDatabase.services;

import _04HospitalDatabase.entities.Medicament;
import _04HospitalDatabase.entities.Town;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.MedicamentModel;
import _04HospitalDatabase.models.TownModel;
import _04HospitalDatabase.repository.MedicamentRepositoryImpl;

import java.io.IOException;
import java.util.List;

import static _04HospitalDatabase.common.Utilities.readStringFromConsole;

public class MedicamentServiceImpl implements Service<Medicament, MedicamentModel> {
    private final MedicamentRepositoryImpl repository;

    public MedicamentServiceImpl(MedicamentRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Medicament create() throws ValidationException, IOException {
        String name = readStringFromConsole("Enter town name: ");
        return this.repository.persist(new MedicamentModel(name));
    }

    @Override
    public List<MedicamentModel> getAll() {
        return this.repository.all();
    }
}
