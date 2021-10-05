package L07WorkshopDataStructures;

public class Main {
    public static void main(String[] args) {
        SmartArray numbers = new SmartArray();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        for (int i = numbers.size()-1; i >= 0 ; i--) {
            System.out.println(numbers.remove(i));
        }
    }
}
