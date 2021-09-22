package review.gk.exam.tecent;

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
    public static void main(String[] args) {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        first.setNext(second);
        second.setNext(third);
        third.setNext(null);
        TreeNode r = reverLinkedList(first);
        while(r != null){
            System.out.print(r.getVal()+" ");
            r = r.next;
        }
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
