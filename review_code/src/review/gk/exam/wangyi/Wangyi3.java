package review.gk.exam.wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wangyi3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputs = scan.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int person = Integer.parseInt(inputs[1]);
        String[] sites = new String[n];
        for(int i = 0;i < n;i++){
            sites[i] = scan.nextLine();
        }
        getSolutions(sites,person);
    }

    private static void getSolutions(String[] sites, int person) {
        Map<Integer,Character> map = new HashMap<>();
        map.put(0,'A');
        map.put(1,'B');
        map.put(2,'C');
        map.put(6,'D');
        map.put(7,'E');
        map.put(8,'F');
        boolean[][] visited = new boolean[sites.length][9];
        String[] res = new String[person + 1];
        int index = 1;
        Outer:
        for(int i = 0; i < sites.length;i++) {
            //遍历每一排的每个位置，判断是否空闲 & 可以安排
            String site = sites[i];
            for(int j = 0; j < 9;j++){
                System.out.print(site.charAt(j));
                if(site.charAt(j) != '.'){
                    continue;
                }else if(canSite(visited,sites,i,j)){
                    visited[i][j] = true;
                    res[index] = new StringBuffer().append(i+1).append(map.get(j)).toString();
                    index += 1;
                    if(index == person+1){
                        res[0] = "SUCCESS";
                        break Outer;
                    }
                }
            }
        }
        if(index < person + 1){
            System.out.println("FAILED");
        }else{
            for(String r : res){
                System.out.println(r);
            }
        }
    }

    //判断i,j位置是否可以安排乘客
    private static boolean canSite(boolean[][] visited,String[] sites, int row, int col) {
        //第一行只需要判断左边是否有空位
        if(col == 0){
            return true;
        }else{
            if(row == 0){
                return !visited[row][col-1];
            }else{
                return !(visited[row][col-1] || visited[row-1][col] || visited[row-1][col-1]);
            }
        }
    }
}
