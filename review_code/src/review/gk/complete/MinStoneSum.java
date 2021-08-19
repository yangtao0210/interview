package review.gk.complete;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MinStoneSum {
    public static void main(String[] args) {
        int[] piles = new int[]{4122,9928,3477,9942};
        System.out.println(minStoneSum(piles,6));
    }
    public static int minStoneSum(int[] piles, int k) {
        int len = piles.length;
        int sum = 0;
        int start = 1;
        Arrays.sort(piles);
        while(k-->0) {
            if(len-start < len-1 && piles[len - start] > piles[len - start - 1])
            piles[len - start] = (int) Math.ceil(1.0 * piles[len - start] / 2);

        }
        for(int i = 0;i < len;i++){
            sum += piles[i];
        }
        return sum;
    }
}