import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        solveProblem1();
        solveProblem2();
        solveProblem3();
    }

   
    // Problem 1: Playlist Management (List)
    public static void solveProblem1() {
        List<String> playlist = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("playlist.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(" ", 2);
                String command = parts[0];

                if (command.equals("ADD")) {
                    String song = parts[1];
                    playlist.add(song);
                } else if (command.equals("INSERT")) {
                    String[] insertParts = parts[1].split(" ", 2);
                    int index = Integer.parseInt(insertParts[0]);
                    String song = insertParts[1];
                    playlist.add(index, song);
                } else if (command.equals("REMOVE")) {
                    String song = parts[1];
                    playlist.remove(song); // Menghapus kemunculan pertama
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File playlist.txt tidak ditemukan.");
            return;
        }

        // Output Problem 1
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
    }

  
    // Problem 2: Workshop Participants (Set)

    public static void solveProblem2() {
        // LinkedHashSet digunakan untuk mempertahankan urutan kemunculan pertama
        Set<String> participants = new LinkedHashSet<>();
        int duplicateCount = 0;

        try (Scanner scanner = new Scanner(new File("participants.txt"))) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) continue;

                if (!participants.add(name)) {
                    duplicateCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File participants.txt tidak ditemukan.");
            return;
        }

        // Output Problem 2
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int index = 1;
        for (String participant : participants) {
            System.out.println(index + ". " + participant);
            index++;
        }
        System.out.println("Duplicate registrations: " + duplicateCount);
    }

    // Problem 3: Product Inventory (Map)

    public static void solveProblem3() {
        // LinkedHashMap digunakan untuk mempertahankan urutan produk pertama kali muncul
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;

        try (Scanner scanner = new Scanner(new File("inventory.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(" ");
                String type = parts[0];
                String product = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                if (type.equals("ADD")) {
                    inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
                } else if (type.equals("SELL")) {
                    if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                        inventory.put(product, inventory.get(product) - quantity);
                    } else {
                        failedSales++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File inventory.txt tidak ditemukan.");
            return;
        }

        // Output Problem 3
        System.out.println("===== Problem 3 =====");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }
}