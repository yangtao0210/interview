package review.gk.design_model.chain;

public class DepartmentHead extends Handler {

    protected DepartmentHead(int maxDay) {
        super(maxDay);
    }

    @Override
    protected void reply(int day) {
        System.out.println(day+"天假，部门负责人审批！");
    }

}
