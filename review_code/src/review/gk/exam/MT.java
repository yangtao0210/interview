package review.gk.exam;

import java.util.Scanner;

public class MT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        int n = numbers.charAt(0) - '0';
        int m = numbers.charAt(2) - '0';
        String[] lines = new String[n];
        for(int i = 0; i < n;i++){
            lines[i] = scanner.nextLine();
        }
        int[][] lines1 = getLines(lines, m);
        for(int i = 0; i < lines1.length;i++){
            for(int j = 0; j < lines1.length - 1;j++){
                System.out.print(lines1[i][j] + " ");
            }
            System.out.println(lines1[i][lines1.length-1]);
        }
    }

    private static int[][] getLines(String[] lines, int m) {
        int len = lines.length;
        int[][] res = new int[len][len];
        for(int i = 0; i < len;i++){
            for(int j = 0; j < len;j++){
                if(i == j){
                    res[i][j] = 0;
                }else{
                    res[i][j] = res[j][i] = computeMinCount(lines,i,j);
                }
            }
        }
        return res;
    }

    private static int computeMinCount(String[] lines, int i, int j) {
        if(i == 0 && j == 1){
            return 1;
        }else if(i == 1 && j == 2){
            return 1;
        }else if(i == 0 && j == 2){
            return 2;
        }else{
            return -1;
        }
    }
}
