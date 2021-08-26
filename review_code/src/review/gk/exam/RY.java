package review.gk.exam;

import java.util.*;
public class RY{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int size = scan.nextInt();
        String[] words = str.split(",");
        List<String> res = fullJustfy(words,size);
        for(String s : res){
            System.out.println(s);
        }
    }
    public static List<String> fullJustfy(String[] words,int maxWidth){
        final String[] space = new String[maxWidth+1];
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < maxWidth+1; i++){
            space[i] = s.toString();
            s.append("*");
        }
        List<String> pWords = new ArrayList<>();
        for(int i = 0;i < words.length;i++){
            int curLen = words[i].length();
            int startI = i;
            while(i < words.length-1 && curLen < maxWidth){
                i++;
                curLen = curLen + words[i].length()+1;
            }
            if(curLen > maxWidth){
                curLen = curLen - words[i].length()-1;
                i--;
            }
            pWords.add(process(words,startI,i,curLen,maxWidth,space));
        }
        return pWords;
    }
    public static String process(String[] words,int si,int ei,int cur,int maxWidth,String[] space){
        StringBuffer sb = new StringBuffer();
        int map = ei - si;
        int addSpace = maxWidth - cur + map;
        if(map == 0){
            sb.append(words[ei]);
            sb.append(space[addSpace]);
            return sb.toString();
        }
        if(ei == words.length-1){
            for(int i = si; i < ei; i++){
                sb.append(words[i]).append("*");
            }
            sb.append(words[ei]);
            sb.append(space[addSpace-map]);
            return sb.toString();
        }
        int allAddSpace = addSpace/map;
        int left = addSpace % map + si;
        for(int i = si;i < ei;i++){
            sb.append(words[i]).append(space[allAddSpace]);
            if(i < left){
                sb.append("*");
            }
        }
        sb.append(words[ei]);
        return sb.toString();
    }


}
