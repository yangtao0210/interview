package review.gk.exam.xc;

import java.util.*;
public class XC {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] chars = str.toCharArray();
        Map<String,Integer> countMap = new HashMap<>();
        countMap.put("letter",0);
        countMap.put("number",0);
        countMap.put("space",0);
        countMap.put("other",0);
        for(char c : chars){
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                countMap.put("letter",countMap.get("letter")+1);
            }else if(c>='0' && c <='9'){
                countMap.put("number",countMap.get("number")+1);
            }else if(c == ' '){
                countMap.put("space",countMap.get("space")+1);
            }else{
                countMap.put("other",countMap.get("other")+1);
            }
        }
        for(String key : countMap.keySet()){
            System.out.println(countMap.get(key));
        }
    }

}