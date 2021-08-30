package review.gk.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KDXF {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] steps = new int[n][2];
        for(int i = 0; i < n; i++){
            steps[i][0] = scan.nextInt();
            steps[i][1] = scan.nextInt();
        }
        double[] pro = getPro(steps);
        for(double p : pro){
            System.out.println(p);
        }
        ArrayList<Object> objects = new ArrayList<>();
        

    }
    public static int getMax(int[] nums){
        int res = 0;
        int left = 0,right = 0;
        for(int i = 0; i < nums.length-1;i++){
            if(nums[i+1] == nums[i]){
                right++;
            }else if(i < nums.length-2 && nums[i+2] == nums[i]){
                //相邻元素不相等时，判断是否需要交换
                int temp = nums[i+2];
                nums[i+2] = nums[i+1];
                nums[i+1] = temp;
            }
            res = Math.max(right-left+1,res);
            System.out.println(Arrays.toString(nums));
        }

        return res;
    }

    public static double[] getPro(int[][] steps){
        double[] res = new double[steps.length];
        for(int i = 0;i < steps.length;i++){
            int[] step = steps[i];
            if(step[0] - step[1] >=0 && step[0] + step[1] <=60){
                res[i] = 1.0;
            }else{
                int diff = Math.abs(step[0]-step[1]);
                if((step[0]+step[1]) > 60){
                    diff += step[0]+step[1] - 60;
                }
                res[i] = 1.0 - (1.0 * diff)/(2*step[1]);
            }
        }
        return res;
    }
}
