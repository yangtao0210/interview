package review.gk.complete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Candy {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Arrays.sort(people,(a,b)->{
            if(a[0] == b[0]){
                //身高相同：小的在前
                return a[1] - b[1];
            }
            //身高从大到小排序
            return b[0] - a[0];
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for(int[] p : people){
            queue.add(p[1],p);
        }
        queue.toArray(new int[people.length][]);
    }
}
