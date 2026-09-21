public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days){
        super(id, days);
    }
    @Override 
    public int calculateCharge(){
        int days = getDays(); 
        int baseCharge; 
        if(days <= 3){
            baseCharge = days * 60000; 
        } else {
            baseCharge = (3*60000) + ((days -3)* 45000);
        }
        return baseCharge + 20000;
    }
    public String label(){
        return "Projector";
    }
}
