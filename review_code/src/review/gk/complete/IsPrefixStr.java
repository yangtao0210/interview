package review.gk.complete;

public class IsPrefixStr {
    public static void main(String[] args) {
        String s = "iloveleetcode";
        String[] words = new String[]{"apples","i","love","leetcode"};
        System.out.println(isPrefixString(s,words));
    }
    public static boolean isPrefixString(String s, String[] words) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < words.length;i++){
            sb.append(words[i]);
            if(sb.toString().equals(s)){
                return true;
            }
        }
        return false;
    }
}
