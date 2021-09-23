package L03SetsAndMapsAdvancedExcercise;

import java.util.*;
import java.util.stream.Collectors;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();

        LinkedHashSet<Integer> nSet = readSet(n, scan);
        LinkedHashSet<Integer> mSet = readSet(m, scan);

        List<Integer> repeatingElements;
        if (nSet.size() > mSet.size()){
             repeatingElements = findRepeating(nSet, mSet);
        } else {
            repeatingElements = findRepeating(mSet, nSet);
        }

        System.out.println(String.join(" ", repeatingElements.stream().map(Object::toString).collect(Collectors.toCollection(ArrayList::new))));
    }

    private static List<Integer> findRepeating(LinkedHashSet<Integer> longerSet, LinkedHashSet<Integer> shorterSet) {
        List<Integer> repeatingElements = new ArrayList<>();
        for (Integer number : longerSet) {
            if (shorterSet.contains(number)){
                repeatingElements.add(number);
            }
        }

        return repeatingElements;
    }

    private static LinkedHashSet<Integer> readSet(int elementsCount, Scanner scan) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < elementsCount; i++) {
            set.add(Integer.parseInt(scan.nextLine()));
        }

        return set;
    }


}
