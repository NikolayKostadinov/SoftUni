package LFE03ProgrammingFundamentalsFinalExamRetake;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P03NeedForSpeed {
    public static final int USABLE_MILEAGE = 100000;
    public static final int MINIMUM_MILEAGE = 10000;
    public static final int FUEL_CAPACITY = 75;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, CarParams> cars = getData();
        modifyData(cars);
        printData(cars);
    }

    private static void printData(Map<String, CarParams> cars) {
        cars
            .entrySet()
            .stream()
            .sorted((c1, c2) -> {
                int result = c2.getValue().getMileage() - c1.getValue().getMileage();
                if (result == 0) {
                    result = c1.getKey().compareTo(c2.getKey());
                }

                return result;
            })
            .forEach(c -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                    c.getKey(), c.getValue().getMileage(), c.getValue().getFuel()));
    }

    private static void modifyData(Map<String, CarParams> cars) {
        String command = scan.nextLine();

        while (!"Stop".equals(command)) {
            String[] tokens = command.split(" : ");
            switch (tokens[0]) {
                case "Drive":
                    drive(cars, tokens);
                    break;
                case "Refuel":
                    refuel(cars, tokens);
                    break;
                case "Revert":
                    revert(cars, tokens);
                    break;
            }
            command = scan.nextLine();
        }

    }

    private static void revert(Map<String, CarParams> cars, String[] tokens) {
        String car = tokens[1];
        int kilometers = Integer.parseInt(tokens[2]);
        CarParams carParams = cars.get(car);

        carParams.setMileage(carParams.getMileage() - kilometers);

        if (carParams.getMileage() < MINIMUM_MILEAGE) {
            carParams.setMileage(MINIMUM_MILEAGE);
        } else {
            System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
        }
    }

    private static void refuel(Map<String, CarParams> cars, String[] tokens) {
        String car = tokens[1];
        int fuel = Integer.parseInt(tokens[2]);
        CarParams carParams = cars.get(car);
        if (carParams.getFuel() + fuel > FUEL_CAPACITY) {
            fuel = FUEL_CAPACITY - carParams.getFuel();
            carParams.setFuel(FUEL_CAPACITY);
        } else {
            carParams.setFuel(carParams.getFuel() + fuel);
        }
        cars.put(car, carParams);
        System.out.printf("%s refueled with %d liters%n", car, fuel);
    }

    private static void drive(Map<String, CarParams> cars, String[] tokens) {
        String car = tokens[1];
        int distance = Integer.parseInt(tokens[2]);
        int fuel = Integer.parseInt(tokens[3]);
        CarParams carParams = cars.get(car);
        if (carParams.fuel < fuel) {
            System.out.println("Not enough fuel to make that ride");
        } else {
            carParams.setMileage(carParams.getMileage() + distance);
            carParams.setFuel(carParams.getFuel() - fuel);
            cars.put(car, carParams);
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", car, distance, fuel);
        }

        if (carParams.getMileage() >= USABLE_MILEAGE) {
            cars.remove(car);
            System.out.printf("Time to sell the %s!\n", car);
        }
    }

    private static Map<String, CarParams> getData() {
        Map<String, CarParams> cars = new HashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\|");
            String car = tokens[0];
            int distance = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            cars.putIfAbsent(car, new CarParams(distance, fuel));
        }

        return cars;
    }

    private static class CarParams {
        private int mileage;
        private int fuel;

        public CarParams(int distance, int fuel) {
            this.mileage = distance;
            this.fuel = fuel;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }
}
