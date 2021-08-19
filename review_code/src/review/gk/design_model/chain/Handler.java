package review.gk.design_model.chain;

//抽象处理者
public abstract class Handler {
    //责任链中下一个处理请求的对象
    private Handler nextHandler;

    //当前领导可以审批通过的最大天数
    int maxDay;
    protected Handler(int maxDay){
        this.maxDay = maxDay;
    }

    //设置责任链中下一个处理请求的对象
    public void setNextHandler(Handler handler){
        nextHandler = handler;
    }

    protected void handleRequest(int day){
        if(day <= maxDay){
            reply(day);
        }else if(nextHandler != null){
            nextHandler.handleRequest(day);
        }else{
            System.out.println(day+"天假，没有更高权限可以审批！");
        }
    }

    protected abstract void reply(int day);

}
