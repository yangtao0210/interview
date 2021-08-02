package review.gk.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//1。交换杯子
public class Main {
    private static int n,x,k;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        k = scanner.nextInt();
        int[][] exchanges = new int[k][2];
        for(int i = 0; i < k;i++){
            exchanges[i][0] = scanner.nextInt();
            exchanges[i][1] = scanner.nextInt();
        }
        System.out.println(getIndex(exchanges));

    }
    static int getIndex(int[][] exchanges){
        int curIndex = x;
        for(int[] exchange : exchanges){
            if(exchange[0] == curIndex){
                curIndex = exchange[1];
            }else if(exchange[1] == curIndex){
                curIndex = exchange[0];
            }
        }
        return curIndex;
    }
}

