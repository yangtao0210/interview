package review.gk.design_model.fatory;

import java.util.Random;

public class Customer {
    private PriceHandler priceHandler;
    public void setPriceHandler(PriceHandler priceHandler){
        this.priceHandler = priceHandler;
    }

    public void requestDiscount(float discount){
        priceHandler.processDiscount(discount);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
        Random random = new Random();
        for (int i = 1; i < 100; i++) {
            customer.requestDiscount(random.nextFloat());
        }
    }
}
