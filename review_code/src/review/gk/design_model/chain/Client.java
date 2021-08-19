package review.gk.design_model.chain;

public class Client {
    public static void main(String[] args) {
        Handler handler1 = new ProjectManager(5);
        Handler handler2 = new DepartmentHead(10);
        handler1.setNextHandler(handler2);
        handler1.handleRequest(2);
        handler1.handleRequest(3);
        handler1.handleRequest(8);
        handler1.handleRequest(12);
    }
}
