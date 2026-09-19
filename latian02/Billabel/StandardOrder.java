public class StandardOrder extends LaundryOrder {
    public StandardOrder(String id, int weightKg){
        super(id, weightKg);
    }

    @Override 
    public int calculateFee(){
        return getweightKg() * 6000; 
    }

    public String serviceType(){
        return "Standard";
    }
}
