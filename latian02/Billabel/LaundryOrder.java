public abstract class LaundryOrder implements Billabel {
    //fields
    private String id; 
    private int weightKg; 


    //GETTER
    public  String getId(){
        return id; 
    }

    public int getweightKg(){
        return weightKg;
    }

    //constructor
    protected LaundryOrder(String id, int weightKg){
        if(weightKg<=0){
            throw new IllegalArgumentException("Weight must be heavier than zero kg."); 
        }
        this.id = id; 
        this.weightKg = weightKg; 
    }

    @Override
    public abstract int calculateFee(); 

    public int calculateFee(int discountPercent){
        if (discountPercent < 0 || discountPercent > 100){
            throw new IllegalArgumentException("BATAL"); 
        } else { 
            return calculateFee() * (100 - discountPercent)/100; 
        }
    }
    
    public String serviceType(){
        return "General"; 
    }

    public String invoice(){
        return id + " | " + serviceType() + " | " + calculateFee();
    }
}
