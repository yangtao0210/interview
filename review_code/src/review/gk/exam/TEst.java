package review.gk.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TEst {
    static boolean foo(char c){
        System.out.println(c);
        return true;
    }
    public static void main(String[] args) {
//       int i = 0;
//       for(foo('A');foo('B') && (i < 2);foo('c')){
//           i++;
//           foo('D');
//       }
        int[] teams = new int[]{1,3,2,4,0,0};
        System.out.println("最终结果："+getTeams(teams));

    }

    public static int getTeams (int[] heros) {
        //统计重复数据出现的数量
        Map<Integer,Integer> map = new HashMap<>();
        for(int hero : heros){
            map.put(hero,map.getOrDefault(hero,0)+1);
        }
        int res = 1;
        System.out.println(map.toString());
        if(map.size() < 5){
            return 0;
        }
        for(int key : map.keySet()){
            res *= map.get(key);
        }
        return res;
    }

}
