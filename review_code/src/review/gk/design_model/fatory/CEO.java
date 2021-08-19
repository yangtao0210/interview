package review.gk.design_model.fatory;

public class CEO extends PriceHandler {

    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.55){
            System.out.format("%s 批准了折扣 %.2f %n",this.getClass().getName(),discount);
        }else{
            //最高领导无后继节点可以处理
            System.out.format("%s 拒绝了折扣 %.2f %n",this.getClass().getName(),discount);
        }
    }
}
