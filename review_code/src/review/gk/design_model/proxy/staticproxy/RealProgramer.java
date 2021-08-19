package review.gk.design_model.proxy.staticproxy;

public class RealProgramer implements Programmer{
    @Override
    public void coding() {
        System.out.println("实际编码对象：写代码");
    }
}
