
import java.util.*;


public class Registration {
    public static List<String> Registration (String[]entries){
        Stack<String> stack = new Stack<>(); 
        Set<String> activeRegistration = new HashSet<>(); 

        for (String entry : entries){
            if ("UNDO".equals(entry)){
                if(!stack.isEmpty()){
                    String removedName = stack.pop(); 
                    activeRegistration.remove(removedName); 
                }
            } else { 
                if(!activeRegistration.contains(entry)){
                    activeRegistration.add(entry);
                    stack.push(entry); 
                 }
            }
        }
        return new ArrayList<>(stack); 
    }
    public static void main(String[] args) {
        String[] data = {"Alya", "Bima", "Alya", "Citra", "UNDO", "Dina", "UNDO", "Citra"};
        List <String> hasil = Registration(data); 
        System.out.println(hasil);       
    }
}
