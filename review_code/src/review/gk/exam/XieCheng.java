package review.gk.exam;

import java.util.Scanner;

public class XieCheng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuffer sb = new StringBuffer();
        sb.append("\\");
        scanner.nextLine();
        for(int i = 0;i < n;i++){
            String line = scanner.nextLine();
            String[] order = line.split(" ");
            if("pwd".equals(order[0])){
                System.out.println(sb.toString());
                continue;
            }
            if("..".equals(order[1])){
                if(sb.length() == 1){
                    continue;
                }
                else{
                    int curIndex = sb.length()-1;
                    while(sb.charAt(curIndex) !='\\'){
                        sb.deleteCharAt(curIndex);
                        curIndex--;
                    }
                    if(sb.length() == 1){
                        continue;
                    }
                    sb.deleteCharAt(curIndex);
                }
            }else{
                if(sb.length() == 1){
                    sb.append(order[1]);
                    continue;
                }
                sb.append("\\").append(order[1]);
            }
        }
    }

}
