package review.gk.design_model.proxy.staticproxy;

public class proxyProgramer implements Programmer{
    //实际对象委托代理对象去完成一些业务
    private RealProgramer realProgramer;

    public proxyProgramer(RealProgramer realProgramer) {
        this.realProgramer = realProgramer;
    }

    //代理对象完成一些实际对象无法完成的业务
    public void upvote(){
        System.out.println("代理对象点赞、评论&收藏文章");
    }
    @Override
    public void coding() {
        //实际业务还是交由实际对象完成
        realProgramer.coding();

        upvote();
    }
}
