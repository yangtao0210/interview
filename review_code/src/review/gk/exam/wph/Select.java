package review.gk.exam.wph;

public class Select {
    static int count = 0;
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                pong();
            }
        };
        t.run();
        System.out.println("Ping");
    }
    static void pong(){
        System.out.println("Pong");
    }
    public static int f(int x){
        if(x <= 2){
            count++;
            return 1;
        }
        return f(x-2) + f(x-4) + 1;
    }
}
