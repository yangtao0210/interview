package review.gk.design_model.fatory;

public abstract class PriceHandler {
    protected PriceHandler successor; //当前节点的后继节点
    public void setSuccessor(PriceHandler successor){
        this.successor = successor;
    }

    public abstract void processDiscount(float discount);
}
