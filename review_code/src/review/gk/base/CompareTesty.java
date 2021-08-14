package review.gk.base;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTesty {
    public static void main(String[] args) {
        int[][] tests = {{10,16},{2,8},{1,6},{7,12}};
        Arrays.sort(tests, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i = 0; i < tests.length;i++){
            System.out.println(Arrays.toString(tests[i]));
        }
    }
}
