import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       
        File file = new File("Rentals.txt");

        Scanner scanner = new Scanner(file); 
        int totalRecords = scanner.nextInt();
        Rental[] Rentals = new Rental[totalRecords]; 
        int[] unitsArray = new int[totalRecords]; 

        for (int i = 0; i < totalRecords; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            unitsArray[i] = units;

            if (type.equalsIgnoreCase("LAPTOP")) {
                    Rentals[i] = new LaptopRental(id, days);
                } else if (type.equalsIgnoreCase("PROJECTOR")) {
                    Rentals[i] = new ProjectorRental(id, days);
                }
            }
            for (int i = 0; i < Rentals.length; i++) {
            Rental r = Rentals[i];
            int units = unitsArray[i];
            System.out.println(r.getId() + " | " + r.label() + " | " + r.calculateCharge(units));
        }
    }
}
