package review.gk.exam;


import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

}
public class TecentYun {
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
