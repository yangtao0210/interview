package review.gk.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class XHS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] scores = new int[n][n];
        for(int i = 0; i < n;i++){
            for(int j = 0;j < n;j++){
                scores[i][j] = scan.nextInt();
            }
        }
        System.out.println(getMax(scores));
    }

    private static int getMax(int[][] scores) {
        int row = scores.length;
        int col = scores[0].length;
        int[][] dp  = new int[row][col];
        dp[0][0] = scores[0][0];
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(i == 0 && j ==0){
                    continue;
                }else if(i == 0){
                    dp[i][j] = scores[i][j] + Math.max(dp[i][j-1],0);
                }else if(j == 0){
                    dp[i][j] = scores[i][j] + Math.max(dp[i-1][j],0);
                }else{
                    dp[i][j] = scores[i][j] + Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[row-1][col-1];
    }

    public static int sumOfAdjacentElements(List<Integer> array) {
        if(array.size() == 2){
            return array.get(0) * array.get(0) + array.get(1) * array.get(1);
        }
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < array.size()-1;i+=2){
            temp.add(array.get(i)+array.get(i+1));
        }
        if(array.size() % 2 != 0){
            temp.add(array.get(array.size()-1));
        }
        return sumOfAdjacentElements(temp);
    }

}

