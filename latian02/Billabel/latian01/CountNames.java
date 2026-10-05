import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap; 

public class CountNames {
    public static void main(String[] args) {
        HashMap<String, Integer> countName = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String name; 
        
        while (true) {
            System.out.print("Enter name: ");
            name = sc.nextLine();
            
            if (name.equals("")) {
                break;
            }
            

            if (countName.containsKey(name)) {
                int count = countName.get(name);
                countName.put(name, count + 1);
            } else {

                countName.put(name, 1);
            }
        }
        
        for (String key : countName.keySet()) {
            System.out.println("Entry [" + key + "] has count " + countName.get(key));
        }
    }
}