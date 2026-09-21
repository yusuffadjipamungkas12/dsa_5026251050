public class LaptopRental extends Rental {
    public LaptopRental(String id, int days){
        super(id, days);
    }
    @Override 
    public int calculateCharge(){
        int days = getDays();
        int setUp = 10000; 
        return (getDays() * 40000) + setUp; 
    }
    public String label(){
        return "Laptop"; 
    }  
}
