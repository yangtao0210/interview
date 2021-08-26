package review.gk.exam;

import java.util.*;

public class ShenCe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        System.out.println(m+"可兑换最小纸币数："+getMinCount(m));
//        String str = scanner.nextLine();
//        getSout(str);
          String str = scanner.nextLine();
        String[] s = str.split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int m = Integer.parseInt(s[2]);
        System.out.println(getPairsCount(x, y, m));

    }

    //1.获取纸币的最小数量
    public static int getMinCount(int m){
        int res = 0;
        if(m/100 != 0){
            res += m/100;
            m %= 100;
        }
        if(m/20 != 0){
            res += m/20;
            m %= 20;
        }
        if(m/10 != 0){
            res += m/10;
            m %= 10;
        }
        if(m/5 !=0){
            res += m/5;
            m %= 5;
        }
        res += m;
        return res;
    }

    //2.获取括号对的开始和结束位置列表
    private static void getSout(String str) {
        LinkedList<Node> stack = new LinkedList<>();
        List<Node> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length;i++){
            if(chars[i] == '('){
                Node node = new Node();
                node.setStart(i);
                stack.push(node);
            }else if(chars[i] == ')'){
                Node pop = stack.pop();
                pop.setEnd(i);
                res.add(pop);
            }
        }

        //按照开始位置排序
        Collections.sort(res,(a,b)->{
            return a.getStart() - b.getStart();
        });

        System.out.println(res.size());
        for(Node n : res){
            System.out.println(n.getStart());
            System.out.println(n.getEnd());
        }
    }

    static class Node{
        int start;
        int end;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }
        public void setEnd(int end) {
            this.end = end;
        }
    }

    //3.很赞的整数对
    public static int getPairsCount(int x,int y ,int m){
        if(x <= 0 && y <= 0){
            return -1;
        }
        if(x > m || y > m){
            return 0;
        }
        int count = 0;
        while( x + y < m){
            ++ count;
            if(x > y){
                y = x + y;
            }else{
                x = x + y ;
            }
        }
        return count + 1;
    }
}
