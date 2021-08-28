package review.gk.exam;

import java.util.*;
import java.text.*;
public class WZ {

    //判断某一天是否为星期一
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        Calendar cald = Calendar.getInstance();
        int res = 0;
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for(int year = start; year <= end;year++){
            for(int month = 1; month <= 12;month++){
                try{
                    date = form.parse(String.valueOf(year)+"-"+String.valueOf(month)+"-01");
                }catch(Exception e){
                    e.printStackTrace();
                }
                cald.setTime(date);
                int day = cald.get(Calendar.DAY_OF_WEEK)-1;
                if(day == 1){
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    //获取愤怒的天数
    public static void getNum(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n;i++){
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int res = 1;
        int index = 0;
        while(index < n){
            if(res <= nums[index]){
                res++;
            }
            index++;
        }
        System.out.println(res);
    }
}