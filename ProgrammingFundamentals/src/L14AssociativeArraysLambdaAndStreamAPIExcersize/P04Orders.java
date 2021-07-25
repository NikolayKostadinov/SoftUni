package L14AssociativeArraysLambdaAndStreamAPIExcersize;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Map<String, Pricing> priceList = new LinkedHashMap<>();

        while (!"buy".equals(command)) {
            String[] tokens = command.split("\\s+");

            priceList.putIfAbsent(tokens[0],
                    new Pricing());
            Pricing newPricing = priceList.get(tokens[0]);
            newPricing.setPrice(Double.parseDouble(tokens[1]));
            newPricing.addQuantity(Integer.parseInt(tokens[2]));
            priceList.put(tokens[0], newPricing);
            command = scan.nextLine();
        }

        priceList.forEach((k,v)-> System.out.printf("%s -> %.2f\n", k, v.getTotalPrice()));
    }

    private static class Pricing {
        private int quantity = 0;
        private double price = 0.0;

        public void addQuantity(int quantity) {
            this.quantity += quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getTotalPrice() {
            return this.quantity * this.price;
        }
    }
}
