package review.gk.base;

public interface A{
    int x = 0;
}
class B{
    int x = 1;
}

class C extends B implements A{
    private Object x;

    public void pX(){
        System.out.println(x);
    }

    public static void main(String[] args) {
        new C().pX();
    }
}
