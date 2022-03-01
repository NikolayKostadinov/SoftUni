package _04HospitalDatabase.services;

import _04HospitalDatabase.entities.Patient;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.AddressModel;
import _04HospitalDatabase.models.PatientModel;
import _04HospitalDatabase.repository.AddressRepositoryImpl;
import _04HospitalDatabase.repository.PatientRepositoryImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static _04HospitalDatabase.common.Utilities.*;

public class PatientService implements Service<Patient, PatientModel> {
    private PatientRepositoryImpl repository;
    private AddressRepositoryImpl addressRepository;

    @Override
    public Patient create() throws ValidationException, IOException {
        String firstName = readStringFromConsole("Enter first name: ");
        String lastName = readStringFromConsole("Enter last name: ");
        printMessage(this.addressRepository.all()
                .stream()
                .map(AddressModel::toString)
                .collect(Collectors.joining(System.lineSeparator())));
        int addressId = readIntFromConsole("Enter address Id: ");
        String email = readStringFromConsole("Enter email: ");
        LocalDate dateOfBirth = LocalDate.parse(readStringFromConsole("Enter birth day /yyyy-mm-dd/: "),
                DateTimeFormatter.ofPattern("yyyy-mm-dd"));
        boolean hasInsurance = readStringFromConsole("Has insurance (Y/N): ").toLowerCase().equals("y");

        return this.repository.persist(new PatientModel(firstName, lastName, addressId, email, dateOfBirth, hasInsurance));
    }

    @Override
    public List<PatientModel> getAll() {
        return null;
    }
}
