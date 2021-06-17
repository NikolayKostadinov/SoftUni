package L09Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list1 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>(list1.size() + list2.size());
        int lastIndex = (list1.size() < list2.size()) ? list1.size() : list2.size();

        for (int i = 0; i < lastIndex; i++) {
                resultList.add(list1.get(i));
                resultList.add(list2.get(i));
        }

        mergeRest(resultList, list1, lastIndex);
        mergeRest(resultList, list2, lastIndex);

        printList(resultList);
    }

    private static void mergeRest(List<Integer> resultList, List<Integer> list, int lastIndex) {
        for (int i = lastIndex; i < list.size() ; i++) {
            resultList.add(list.get(i));
        }
    }

    private static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder(list.size() * 2);
        for (int num : list) {
            sb.append(String.format("%d ", num));
        }
        System.out.println(sb);
    }
}
