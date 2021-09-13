package review.gk.exam.tencentcloud;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numStrs = scan.nextLine().split(",");
        int len = numStrs.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }
        reverseNums(nums);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(nums[i]).append(",");
        }
        System.out.println(sb.substring(0, sb.length() - 1).toString());
    }

    public static void reverseNums(int[] nums) {
        int len = nums.length;
        for (int i = 0; i <= len / 2; i += 2) {
            if (i == 0) {
                swap(nums, 1, len - 1);
            } else {
                swap(nums, i, len - 1);
                if (i != len / 2) {
                    swap(nums, i + 1, len - i + 1);
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
