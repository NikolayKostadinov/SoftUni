package P06VehicleCatalogue;

import java.util.Locale;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int horsePowers;

    public Vehicle(String str) {
        String[] input = str.split(" ");
        this.type = input[0];
        this.model = input[1];
        this.color = input[2];
        this.horsePowers = Integer.parseInt(input[3]);
    }

    public String getType() {
        return type;
    }

    public int getHorsePowers() {
        return horsePowers;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString(){
        return String.format("Type: %s\n" +
                "Model: %s\n" +
                "Color: %s\n" +
                "Horsepower: %d", this.type.toUpperCase(Locale.ROOT).charAt(0) + this.type.substring(1), this.model, this.color, this.horsePowers);
    }
}
