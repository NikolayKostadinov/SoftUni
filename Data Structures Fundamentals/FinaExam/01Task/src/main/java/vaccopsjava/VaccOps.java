package vaccopsjava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VaccOps implements IVaccOps {
    private Map<Doctor, List<Patient>> docPatients;

    public VaccOps() {
        this.docPatients = new LinkedHashMap<>();
    }

    public void addDoctor(Doctor d) {
        if (docPatients.containsKey(d)) {
            throw new IllegalArgumentException();
        }
        docPatients.put(d, new ArrayList<>());
    }

    public void addPatient(Doctor d, Patient p) {
        if (!docPatients.containsKey(d)) {
            throw new IllegalArgumentException();
        }

        if (this.docPatients.get(d).contains(p)) throw new IllegalArgumentException();
        this.docPatients.get(d).add(p);
    }

    public Collection<Doctor> getDoctors() {
        return new ArrayList<>(this.docPatients
                .keySet());
    }

    public Collection<Patient> getPatients() {

        return this.docPatients.values()
                .stream()
                .flatMap(p -> p.stream())
                .collect(Collectors.toList());
    }

    public boolean exist(Doctor d) {
        return this.docPatients.containsKey(d);
    }

    //todo:test
    public boolean exist(Patient p) {
        return this.docPatients.values()
                .stream()
                .anyMatch(d -> d.contains(p));
    }

    public Doctor removeDoctor(String name) {

        Doctor doctor = this.docPatients.keySet()
                .stream()
                .filter(d -> d.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());

        this.docPatients.remove(doctor);
        return doctor;
    }

    public void changeDoctor(Doctor from, Doctor to, Patient p) {
        if (!this.docPatients.containsKey(from) || !this.docPatients.containsKey(to)) {
            throw new IllegalArgumentException();
        }

        if (!this.docPatients.get(from).remove(p) || this.docPatients.get(to).contains(p)) {
            throw new IllegalArgumentException();
        }


        this.docPatients.get(to).add(p);
    }

    public Collection<Doctor> getDoctorsByPopularity(int populariry) {

        return this.docPatients.keySet()
                .stream()
                .filter(d -> d.popularity == populariry)
                .collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsByTown(String town) {
        List<Patient> patients = new ArrayList<>();
        this.docPatients.entrySet()
                .stream()
                .forEach(ps -> ps.getValue()
                        .stream()
                        .filter(pa -> pa.town.equals(town))
                        .forEach(pa -> patients.add(pa)));
        return patients;
    }

    public Collection<Patient> getPatientsInAgeRange(int lo, int hi) {
        return this.docPatients.entrySet()
                .stream()
                .flatMap(d -> d.getValue().stream())
                .filter(pa -> lo <= pa.age && pa.age <= hi)
                .collect(Collectors.toList());

    }

    public Collection<Doctor> getDoctorsSortedByPatientsCountDescAndNameAsc() {
        if (this.docPatients.isEmpty()) return new ArrayList<>();

        return
                this.docPatients
                        .entrySet()
                        .stream()
                        .sorted((d1, d2) -> {
                            int result = d2.getValue().size() - d1.getValue().size();
                            if (result == 0) {
                                result = d1.getKey().name.compareTo(d2.getKey().name);
                            }
                            return result;
                        })
                        .map(d -> d.getKey())
                        .collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsSortedByDoctorsPopularityAscThenByHeightDescThenByAge() {
        if (this.docPatients.isEmpty() || this.docPatients.values().isEmpty()) return new ArrayList<>();

        ArrayList<DoctorPatient> list = new ArrayList<>();
        this.docPatients
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(d -> d.getKey().popularity))
                .forEach(dp -> dp.getValue()
                        .stream()
                        .forEach(p -> list.add(new DoctorPatient(dp.getKey(), p))));
        if (list.isEmpty()) return new ArrayList<>();
        ArrayList<Patient> patients = new ArrayList<>();

        list.stream()
                .sorted((dp1, dp2) -> {
                    int result = dp1.doctor.popularity - dp2.doctor.popularity;
                    if (result == 0) {
                        result = dp2.patient.height - dp1.patient.height;
                        if (result == 0) {
                            result = dp1.patient.age - dp2.patient.age;
                        }
                    }
                    return result;
                })
                .forEach(p -> patients.add(p.patient));

        return patients;
    }

    class DoctorPatient {
        Doctor doctor;
        Patient patient;

        public Patient getPatient() {
            return patient;
        }

        public DoctorPatient(Doctor doctor, Patient patient) {
            this.doctor = doctor;
            this.patient = patient;


        }
    }

}
