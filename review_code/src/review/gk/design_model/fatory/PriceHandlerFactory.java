package review.gk.design_model.fatory;

public class PriceHandlerFactory {
    public static PriceHandler createPriceHandler(){
        PriceHandler sale = new Sales();
        PriceHandler lead = new Manager();
        PriceHandler director = new Director();
        PriceHandler vp = new VicePresident();
        PriceHandler ceo = new CEO();
        sale.setSuccessor(lead);
        lead.setSuccessor(director);
        director.setSuccessor(vp);
        vp.setSuccessor(ceo);
        return sale;
    }
}
