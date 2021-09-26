package review.gk.exam.tecent;

import com.sun.javaws.exceptions.UnsignedAccessViolationException;

import java.io.Console;
import java.rmi.AccessException;
import java.util.Hashtable;
import java.util.Vector;

class TreeNode{
    public int getVal() {
        return val;
    }

    int val;
    TreeNode next;

    TreeNode(int val){
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }

}
public class FirstInterview {
    private static int i =1;
    public int getNext(){
        return i++;
    }
    public static void main(String[] args) {
//        TreeNode first = new TreeNode(1);
//        TreeNode second = new TreeNode(2);
//        TreeNode third = new TreeNode(3);
//        first.setNext(second);
//        second.setNext(third);
//        third.setNext(null);
//        TreeNode r = reverLinkedList(first);
//        while(r != null){
//            System.out.print(r.getVal()+" ");
//            r = r.next;
//        }
//        FirstInterview f = new FirstInterview();
//        FirstInterview f1 = new FirstInterview();
//        f.getNext();
//        f1.getNext();
//        System.out.println(f1.getNext());
       String s = "hello\0";

    }
    public static TreeNode reverLinkedList(TreeNode root){
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null){
            TreeNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
