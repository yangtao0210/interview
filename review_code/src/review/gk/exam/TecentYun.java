package review.gk.exam;


import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

}

public class TecentYun {
    public static void main(String[] args) {
        int[] path = new int[]{1,2,3};
        int[] path1 = new int[]{2,3,4};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> p1 = new ArrayList<>();
        p1.add(1);
        p1.add(2);
        p1.add(3);
        List<Integer> p2 = new ArrayList<>();
        p2.add(2);
        p2.add(3);
        p2.add(4);
        res.add(p1);
        res.add(p2);
        for (List<Integer> l : res){
            System.out.println(l.toString()+"\t");
        }
    }

    


    public List<TreeNode> tree(TreeNode root){
        //存储遍历结果
        List<TreeNode> nodeList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- != 0){
                TreeNode temp = queue.remove();
                nodeList.add(temp);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        return nodeList;
    }

    public boolean isIllegal(String input){
        Map<Character,Character> map = new HashMap<>();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
        Stack<Character> stack =  new Stack<>();
        char[] chars = input.toCharArray();
        for(char c : chars){
            if(c == '[' || c=='(' || c == '{'){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    char temp = stack.peek();
                    if(c == map.get(temp)){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
