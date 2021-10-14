package L09IteratorsAndComparatorsExercise.P08PetClinics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private String name;
    private final List<Pet> pets;
    private final ClinicAddIterator iterator;

    public Clinic(String name, int rooms) {
        if (rooms % 2 == 0) throw new IllegalStateException("Invalid Operation!");
        this.name = name;
        this.pets = Arrays.asList(new Pet[rooms]);
        iterator = new ClinicAddIterator(pets);
    }

    public boolean add(Pet pet) {
        if (this.iterator.hasNext()) {
            this.iterator.add(pet);
            return true;
        }
        return false;
    }

    public boolean release(){
        return this.iterator.release();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.pets.stream().map(Pet::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public boolean hasEmptyRooms(){
        return iterator.hasNext();
    }

    public void getRoom(int index) {
        this.pets.get(index);
    }
}
