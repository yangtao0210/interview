package review.gk.design_model.proxy.dynamicproxy.jdk;

public class TeachImpl implements Teach {

    @Override
    public void doTeach() {
        for(int i =0 ;i < 20000;i++){
            System.out.println("Do teach...");
        }
    }
}
