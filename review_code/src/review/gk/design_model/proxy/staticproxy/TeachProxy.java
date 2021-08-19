package review.gk.design_model.proxy.staticproxy;

public class TeachProxy implements Teach {

    private Teach teach;
    public TeachProxy(Teach teach){
        this.teach = teach;
    }
    @Override
    public void doTeach() {
        long startTime = System.currentTimeMillis();
        //委托原始类执行业务
        this.teach.doTeach();
        long endTime = System.currentTimeMillis();
        long teachTime = endTime - startTime;
        System.out.println("Time :"+teachTime);
    }
    
}
