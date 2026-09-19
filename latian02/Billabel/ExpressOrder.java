public class ExpressOrder extends LaundryOrder{
    public ExpressOrder (String id, int weightKg){
        super(id, weightKg);
    }

    @Override 
    public int calculateFee(){
        int weightKg = getweightKg();
        int setFee = 5000; 
        if (weightKg > 5){
            return (weightKg * 8000) + setFee; 
        } else {
            return getweightKg()*10000; 
        }
    }
    public String serviceType(){
        return "Express"; 
    }
}