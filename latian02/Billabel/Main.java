import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<LaundryOrder> orders = new ArrayList<>();
        File file = new File("orders.txt");

        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNext()){
                String type = scanner.next();
                String id = scanner.next(); 
                int weight = scanner.nextInt(); 

                 if (type.equalsIgnoreCase("STANDARD")) {
                    orders.add(new StandardOrder(id, weight));
                } else if (type.equalsIgnoreCase("EXPRESS")) {
                    orders.add(new ExpressOrder(id, weight));
                }
            }
        }
        
        for (LaundryOrder order : orders){
            System.out.println(order.invoice());
        }
    }
}
