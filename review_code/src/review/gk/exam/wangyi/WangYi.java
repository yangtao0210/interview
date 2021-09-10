package review.gk.exam.wangyi;

public class WangYi {
    public static void main(String[] args) {
        System.out.println(canBePalindromicString("ab"));
    }
    //添加字符变为回文串
    public static int canBePalindromicString (String str1) {
        int left = 0;
        int right = str1.length()-1;
        String reverStr = new StringBuffer(str1).reverse().toString();
        int flag = 0;
        while(left<=right){
            if(str1.charAt(left)!=str1.charAt(right)){
                if(str1.charAt(left)==str1.charAt(right-1)&&left<=right-1){
                    flag++;
                    right--;
                }else if(str1.charAt(left+1)==str1.charAt(right)&&left+1<=right){
                    flag++;
                    left++;
                }else{
                    flag = flag+2;
                    break;
                }
            }else{
                left++;
                right--;
            }
        }
        if(flag<3){
            return 1;
        }else{
            return 0;
        }
    }
}
