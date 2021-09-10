package review.gk.exam.wangyi;

import java.util.Scanner;

public class Wangyi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int k = Integer.parseInt(strs[1]);
        System.out.println(getLength(strs[0], k));
    }
    public static int getLength(String str,int k){
        return 0;
    }
}
