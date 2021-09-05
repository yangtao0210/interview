package review.gk.exam;

import java.util.HashSet;

public class HKWS {
    static HKWS hkws = new HKWS();
    static int a;
    static int b = 1;
    HKWS(){
        a++;
        b++;
    }
    static HKWS getInstance(){
        return hkws;
    }

    public static void main(String[] args) {
        HKWS instance = HKWS.getInstance();
        System.out.println(a+" "+b);
    }
}
