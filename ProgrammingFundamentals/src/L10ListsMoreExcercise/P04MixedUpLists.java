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
        List<Integer> range = new ArrayList<>(2);
        int maxLength;
        if (nums1.size() > nums2.size()){
            range = nums1.subList(nums1.size() - 2, nums1.size());
            nums1 = nums1.subList(0, nums1.size() - 2);
            range.sort(Integer::compareTo);
            maxLength = nums2.size();
        } else {
            range = nums2.subList(0, 2);
            nums2 = nums2.subList(2, nums2.size());
            range.sort(Integer::compareTo);
            maxLength = nums1.size();
        }

        List<Integer> mix = new ArrayList<>(maxLength * 2);

        for (int i = 0; i < maxLength; i++) {
                mix.add(nums1.get(i));
                mix.add(nums2.get(nums2.size() - i - 1));
        }

        mix.sort(Integer::compareTo);
        List<Integer> finalRange = range;
        mix = mix.stream().filter(x -> finalRange.get(0) < x && x < finalRange.get(1)).collect(Collectors.toList());
        System.out.println(mix.toString().replaceAll("[\\[\\],]", ""));
    }
}
