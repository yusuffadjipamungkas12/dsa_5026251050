import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Linkedhash untuk urutan
        Map<String, Integer> enrollment = new LinkedHashMap<>();
        
        List<String> checkResults = new ArrayList<>();
        
        int rejectedOperations = 0;

        try (Scanner scanner = new Scanner(new File("enrollment.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(" ");
                String command = parts[0];
                String courseCode = parts[1];

                if (command.equals("REGISTER")) {
                    int count = Integer.parseInt(parts[2]);
                    // Tolak jika jumlah <= 0
                    if (count <= 0) {
                        rejectedOperations++;
                    } else {
                        // Jika sudah ada, tambahkan. Jika belum, buat record baru
                        if (enrollment.containsKey(courseCode)) {
                            enrollment.put(courseCode, enrollment.get(courseCode) + count);
                        } else {
                            enrollment.put(courseCode, count);
                        }
                    }
                } else if (command.equals("WITHDRAW")) {
                    int count = Integer.parseInt(parts[2]);
                    // Tolak jika jumlah <= 0
                    if (count <= 0) {
                        rejectedOperations++;
                    } else {
                        // Jika course ada dan pendaftar mencukupi, kurangi pendaftar
                        if (enrollment.containsKey(courseCode) && enrollment.get(courseCode) >= count) {
                            enrollment.put(courseCode, enrollment.get(courseCode) - count);
                        } else {
                            // Tolak jika course tidak ada atau pendaftar kurang 
                            rejectedOperations++;
                        }
                    }
                } else if (command.equals("CHECK")) {
                    // Cek ketersediaan dan simpan 
                    if (enrollment.containsKey(courseCode)) {
                        checkResults.add(courseCode + ": " + enrollment.get(courseCode) + " students");
                    } else {
                        checkResults.add(courseCode + ": Not found");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File enrollment.txt tidak ditemukan.");
            return;
        }

        // CHECK
        System.out.println("===== Enrollment Checks =====");
        for (String result : checkResults) {
            System.out.println(result);
        }

        // Output pendaftaran
        System.out.println("===== Final Enrollment =====");
        for (Map.Entry<String, Integer> entry : enrollment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " students");
        }
        System.out.println("Rejected operations: " + rejectedOperations);
    }
}