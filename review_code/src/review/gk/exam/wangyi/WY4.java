package review.gk.exam.wangyi;

import java.util.*;
public class WY4{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] inputs = scan.nextLine().split(" ");
        int[] nums = new int[inputs.length];
        for(int i = 0;i < inputs.length;i++){
            nums[i] = Integer.parseInt(inputs[i]);
        }
        int x = Integer.parseInt(scan.nextLine());
        quickSort(nums,0,nums.length-1);
        System.out.println(binarySearch(nums,0,nums.length-1,x));
    }
    public static int getMinCount(String input,int m){
        int res = 1;
        char[] inputs = input.toCharArray();
        int imageCount = getMerCount(inputs,m);
        for(int i = 1;i < inputs.length;i++){
            res++;
            res += Math.abs(inputs[i]-inputs[i-1]);
        }
        res = Math.min(res,imageCount);
        return res;
    }
    public static int getMerCount(char[] inputs,int m){
        int res = 1;
        int index = 0;
        while(index < inputs.length - m){
            int temp  = 1;
            for(int i = 1; i <=index;i++){
                temp += Math.abs(inputs[i]-inputs[i-1]);
            }
            temp += m*2;
            for(int i = index + m;i < inputs.length;i++){
                temp += Math.abs(inputs[i]-inputs[i-1]);
            }
            res = Math.min(temp,res);
        }
        return res;
    }
    //二分查找
    public static int binarySearch(int[] nums,int left,int right,int x){
        int index = -1;
        while(left <= right){
            int mid = (left + right)/2 - left;
            if(nums[mid] == x){
                return mid;
            }else if(nums[mid] < x){
                return binarySearch(nums,left,mid-1,x);
            }else{
                return binarySearch(nums,mid+1,right,x);
            }
        }
        return index;
    }

    //快排
    public static void quickSort(int[] nums,int left,int right){
        if(left < right){
            int index = patition(nums,left,right);
            System.out.println("基准："+index);
            quickSort(nums,left,index-1);
            quickSort(nums,index + 1,right);
        }
    }

    public static int patition(int[] nums,int left,int right){
        int pivot = nums[left];
        int i = left,j = right;
        while(i < j){
            //从左往右找到第一个大于基准的下标
            while(nums[i] <= pivot && i < j){
                i++;
            }
            //从右往左找到第一个小于基准的下标
            while(nums[j] >= pivot && i < j){
                j--;
            }

            //交换两个元素并执行下次循环
            swap(nums,i,j);
        }
        swap(nums,left,i);
        return i;
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
