public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days){
        super(id, days);
    }
    @Override 
    public int calculateCharge(){
        int days = getDays(); 
        int setProject = 20000; 
        if(getDays() > 3){
            return (3*60000) + ((getDays()-3)*45000) + (getDays()*setProject);
        } else {
            return (getDays()*60000);
        }
    }
}
