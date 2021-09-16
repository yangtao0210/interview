package review.gk.exam.sf;

import java.util.Arrays;
import java.util.Scanner;

public class SF_Visited {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int[][] visited = new int[m][3];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < 3;j++){
                visited[i][j] = scanner.nextInt();
            }
        }
        int[][] path = new int[q][2];
        for(int i = 0;i < q;i++){
            path[i][0] = scanner.nextInt();
            path[i][1] = scanner.nextInt();
        }

        printResult(visited,path);
    }

    private static void printResult(int[][] visited, int[][] path) {
        Arrays.sort(visited,(a,b)->{
            return a[0] - b[0];
        });
        for(int i = 0; i < path.length;i++){
            if(path[i][0] == path[i][1]){
                System.out.println(0);
            }else{
                System.out.println(getMax(visited,path[i][0],path[i][1]));
            }
        }
    }

    private static int getMax(int[][] visited, int start, int end) {
        int l = start, r = end;
        int max = 0;
        for (int i = 0; i < visited.length;i++){
            if(l < visited[i][0]){
                continue;
            }else if(l==visited[i][0] && r == visited[i][1]){
                max = Math.max(max,visited[i][2]);
                break;
            }else{
                max = Math.max(max,visited[i][2]);
                l = visited[i][1];
            }
        }
        return max;
    }
}
