package review.gk.test;

import java.io.*;
import java.util.*;

class AQY{
    static int[] S;
    static int[] A;
    static int K;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String[] s = cin.nextLine().split(":");
        String[] as = s[0].split(",");
        A = new int[as.length];
        S = new int[as.length+1];
        for(int i = 0; i < as.length;i++){
            A[i] = Integer.parseInt(as[i]);
            S[i+1] = S[i] + A[i];
        }
        double ans = 0.0;
        double last = 0;
        K = Integer.parseInt(s[1]);
        for(int l = 0; l+K-1 < A.length;l++){
            int r = l+K-1;
            if(l==0){
                last = (double)(S[r+1]-S[l])/K;

            }else{
                double temp = (double) (S[r+1]-S[l])/K;
                double zf = (temp -last)/last;
                System.out.println(zf);
                ans = Math.max(ans,zf);
                last = temp;
            }
        }
        ans = ans*100.0;
        String res = String.format("%.2f",ans);
        System.out.println(res+"%");
    }

    public static int[] floors(int[] rains){
        int len = rains.length;
        int[] res = new int[len];
        Arrays.fill(res,-1);
        Map<Integer,Integer> map = new HashMap<>();
        List<Need> needs = new LinkedList<>();
        for(int i = 0; i < len;i++){
            int rain = rains[i];
            if(rain == 0){
                continue;
            }
            Integer pre = map.getOrDefault(rain,-1);
            if(pre != -1){
                needs.add(new Need(pre,i,rain));
            }
            map.put(rain,i);
        }
        needs.sort(Comparator.comparingInt(n->n.end));

        for(int i = 0;i < rains.length;i++){
            if(rains[i] == 0){
                Iterator<Need> each = needs.iterator();
                while(each.hasNext()){
                    Need needNext = each.next();
                    if(needNext.end < i){
                        return new int[0];
                    }
                    if(needNext.start < i){
                        res[i] = needNext.node;
                        each.remove();
                        break;
                    }
                }
                if(res[i] == -1){
                    res[i] = 1;
                }
            }
        }
        if(needs.size() > 0){
            return new int[0];
        }
        return res;
    }

    static class Need{
        public int start;
        public int end;
        public int node;

        public Need(Integer start,Integer end,Integer node){
            this.start = start;
            this.end = end;
            this.node = node;
        }
    }

}
