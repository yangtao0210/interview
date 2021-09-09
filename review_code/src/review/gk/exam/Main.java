package review.gk.exam;

import java.util.*;

public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String[] line= sc.nextLine().split(" ");

        int m = Integer.parseInt(line[1]);

        String[] strs = sc.nextLine().split("0");

        Arrays.sort(strs,(a,b)->(b.length()-a.length()));

        int[][] path = new int[m][2];

        for(int i = 0;i<m;i++)
        {
            path[i][0] = sc.nextInt();
            path[i][1] = sc.nextInt();
        }
        int maxLeng = strs[0].length();
        int[] dp = new int[maxLeng+1];
        for(int i = 1;i<maxLeng + 1;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i - path[i][0] >= 0)
                {
                    dp[i] = Math.max(dp[i],dp[i-path[j][0]]+path[i][1]);
                }
            }
        }
        int totalScore = 0;
        for(String str:strs)
        {
            totalScore += dp[str.length()];
        }
        System.out.println(totalScore);
    }
}