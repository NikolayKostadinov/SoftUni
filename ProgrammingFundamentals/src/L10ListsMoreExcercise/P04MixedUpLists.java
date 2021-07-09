package L10ListsMoreExcercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04MixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> nums1 = Arrays.stream(scan.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> nums2 = Arrays.stream(scan.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());
        int maxLength = (nums1.size() < nums2.size()) ? nums1.size():nums2.size();

        List<Integer> mix = new ArrayList<>(maxLength * 2);

        for (int i = 0; i < maxLength; i++) {
                mix.add(nums1.get(0));
                nums1.remove(0);
                mix.add(nums2.get(nums2.size() - 1));
                nums2.remove(nums2.size() - 1);
        }

        List<Integer> range = nums1;
        range.addAll(nums2);
        range.sort(Integer::compareTo);
        mix.sort(Integer::compareTo);
        mix = mix.stream().filter(x -> range.get(0) < x && x < range.get(1)).collect(Collectors.toList());
        System.out.println(mix.toString().replaceAll("[\\[\\],]", ""));
    }
}
