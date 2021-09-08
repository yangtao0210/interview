package review.gk.exam;

import java.util.*;

public class XM {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int m = s.charAt(2)-'0';
        int n = s.charAt(6)-'0';
        int[] a = new int[m+n];
        int[] b = new int[n];
        String mStr = scan.next();
        String nStr = scan.next();
        String[] msplit = mStr.split(",");
        String[] nsplit = nStr.split(",");
        for(int i =0; i < m;i++){
            a[i] = Integer.parseInt(msplit[i]);
        }
        for(int i =0; i < n;i++){
            b[i] = Integer.parseInt(nsplit[i]);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(((o1, o2) -> {
            return o1.getValue() - o2.getValue();
        }));
        int x = m;
        for(int i=0; i < b.length; i++) {
            a[x++] = b[i];
        }
        Arrays.sort(a);

        for (int i = 0; i < a.length;i++){
            System.out.println(a[i]);
        }
    }
}
