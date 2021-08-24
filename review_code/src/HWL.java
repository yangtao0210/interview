import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HWL{
    static boolean foo(char c){
        System.out.println(c);
        return true;
    }
    public static void main(String[] args) {
//        int i = 0;
//        for (foo('B');foo('A')&&(i < 2);foo('D')){
//            i++;
//            foo('C');
//        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> re : res) {
            re.get(-1);
        }
        System.out.println(MaxMin(new int[]{2,1,5},2));
    }

    public static int MaxMin (int[] A, int m) {
        if(A == null || A.length < 2){
            return 0;
        }
        int res = 0;
        for(int i = 0; i <= A.length - m; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(A[i]);
            int index = 0;
            while(index < A.length && temp.size() < m){
                if(!temp.contains(A[index])){
                    temp.add(A[index++]);
                }
            }
            Collections.sort(temp);
            res += (temp.get(temp.size()-1)-temp.get(0))%(Math.pow(10,9)+7);
        }
        return res;
    }
}
