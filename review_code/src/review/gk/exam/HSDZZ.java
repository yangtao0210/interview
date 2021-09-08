package review.gk.exam;

public class HSDZZ extends F {
    public static void main(String[] args) {
        char seq = 1;
        int overflow = 0;
        for(int i = 0; i < 1020;i++){
            if(++seq == 0){
                ++seq;
                overflow++;
            }
        }
        System.out.printf("%d",overflow);
        System.out.println(10*('*'-'0'));

    }
}
class F{
    private int age;
}
