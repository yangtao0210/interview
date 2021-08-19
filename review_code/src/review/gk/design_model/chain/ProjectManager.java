package review.gk.design_model.chain;

public class ProjectManager extends Handler {

    protected ProjectManager(int maxDay) {
        super(maxDay);
    }

    @Override
    protected void reply(int day) {
        System.out.println(day+"天假，项目经理审批！");
    }

}
