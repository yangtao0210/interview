package review.gk.exam.sf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SF{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[5];
        for(int i = 0; i < 5; i++){
            scores[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int[][] shits = new int[n][5];
        for(int i = 0;i < n;i++){
            for(int j = 0; j < 5;j++){
                shits[i][j] = scanner.nextInt();
            }
        }
        printOut(scores,shits);
    }

    private static void printOut(int[] scores, int[][] shits) {
        int max = 0;
        int len = shits.length;
        int[] highs = new int[len];
        for(int i = 0; i < len;i++){
            for(int j = 0; j < 5;j++){
                highs[i] += scores[j]*shits[i][j];
            }
            max = Math.max(max,highs[i]);
        }
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < len;i++){
            if(highs[i] == max){
                indexs.add(i+1);
            }
        }
        System.out.println(max);
        System.out.println(indexs.size());
        for(int index : indexs){
            System.out.println(index);
        }
    }
}
