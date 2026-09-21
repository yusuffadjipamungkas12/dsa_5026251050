public abstract class Rental implements Chargeable {
    //fields
    private String id; 
    private int days; 

    //GETTER METHODS
    public String getId(){
        return id;
    }
    
    public int getDays(){
        return days;
    }
    //constructor
    protected Rental(String id, int days){
        this.id = id; 
        this.days = days; 
        if(getDays () <= 0){
            throw new IllegalArgumentException("Days must be over than zero.");
        }
    }

    @Override 
    public abstract int calculateCharge();
    public int calculateCharge(int units){
        if(units <= 0){
            throw new IllegalArgumentException("BATAL");
        } else { 
            return units * calculateCharge();
        }
    }
    public String label(){
        return "Rental"; 
    }
    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}
