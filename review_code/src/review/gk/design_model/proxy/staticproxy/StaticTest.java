package review.gk.design_model.proxy.staticproxy;

public class StaticTest {
    public static void main(String[] args) {
        proxyProgramer proxyProgramer = new proxyProgramer(new RealProgramer());
        proxyProgramer.coding();
    }
}
