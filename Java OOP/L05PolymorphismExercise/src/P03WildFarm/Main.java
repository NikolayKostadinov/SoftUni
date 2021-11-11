package P03WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Animal> animals = new ArrayList<>();
        while (!"End".equals(input)) {
            Animal animal = createAnimal(input);
            Food food = createFood(scan.nextLine());
            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            animals.add(animal);
            input = scan.nextLine();
        }

        System.out.println(animals.stream()
                .map(Animal::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static Food createFood(String input) {
        String[] tokens = input.split("\\s+");
        int quantity = Integer.parseInt(tokens[1]);
        switch (tokens[0]) {
            case "Vegetable":
                return new Vegetable(quantity);
            case "Meat":
                return new Meat(quantity);
            default:
                return null;
        }
    }

    private static Animal createAnimal(String input) {
        String[] tokens = input.split("\\s+");
        String animalType = tokens[0];
        String animalName = tokens[1];
        Double animalWeight = Double.parseDouble(tokens[2]);
        String animalLivingRegion = tokens[3];

        switch (animalType) {
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            case "Cat":
                String bread = tokens[4];
                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, bread);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            default:
                return null;
        }
    }
}
