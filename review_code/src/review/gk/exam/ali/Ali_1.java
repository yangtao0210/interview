package review.gk.exam.ali;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ali_1 {
    private int age;
    protected  String name;
    public int id;
    public static void main(String[] args){
        System.out.println((10/3)*2%5);
        StringBuffer sb = new StringBuffer("abfd");
        System.out.println(sb.capacity());
    }
    public static int getMaxCount(int n,int[] highs){
        int max = 1;
        for(int i = 0;i < n;i++){
            int res = 1;
            if(i == 0){
                res += highs[i+1] < highs[i]?1:0;
            }else if(i == n-1){
                res += highs[i] > highs[i-1]?1:0;
            }else{
                if(highs[i] > highs[i-1]){
                    res++;
                }
                if(highs[i] > highs[i+1]){
                    res++;
                }
            }
            max = Math.max(res,max);
        }
        return max;
    }
}

