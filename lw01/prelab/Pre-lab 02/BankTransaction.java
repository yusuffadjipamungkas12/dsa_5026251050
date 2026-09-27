import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BankTransaction {
    public static void main(String[] args) {
        // 1. LinkedList untuk menyimpan semua baris transaksi dari file
        LinkedList<String[]> rawTransactions = new LinkedList<>();

        // 2. LinkedList untuk menyimpan data unik nasabah [Nama, Saldo]
        LinkedList<String[]> customers = new LinkedList<>();

        // Membaca file transactions.txt
        try {
            File file = new File("transactions.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                // Format: <NAME> <TYPE> <AMOUNT>
                String[] parts = line.split("\\s+");
                rawTransactions.add(parts);

                // Cek apakah nasabah sudah ada di customers list
                String name = parts[0];
                boolean exists = false;
                for (String[] cust : customers) {
                    if (cust[0].equals(name)) {
                        exists = true;
                        break;
                    }
                }

                // Jika nasabah baru pertama kali muncul, tambahkan dengan saldo awal 0
                if (!exists) {
                    customers.add(new String[]{name, "0"});
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File transactions.txt tidak ditemukan!");
            return;
        }

        // 3. Pindahkan semua transaksi ke Queue (FIFO)
        Queue<String[]> transactionQueue = new LinkedList<>();
        for (String[] tx : rawTransactions) {
            transactionQueue.add(tx);
        }

        // 4. Stack untuk menampung transaksi gagal (LIFO)
        Stack<String[]> failedTransactions = new Stack<>();

        // Proses transaksi dari Queue secara FIFO
        while (!transactionQueue.isEmpty()) {
            String[] tx = transactionQueue.poll();
            String name = tx[0];
            String type = tx[1];
            int amount = Integer.parseInt(tx[2]);

            // Cari objek nasabah yang bersangkutan
            String[] targetCustomer = null;
            for (String[] cust : customers) {
                if (cust[0].equals(name)) {
                    targetCustomer = cust;
                    break;
                }
            }

            if (targetCustomer != null) {
                int currentBalance = Integer.parseInt(targetCustomer[1]);

                if (type.equalsIgnoreCase("DEPOSIT")) {
                    currentBalance += amount;
                    targetCustomer[1] = String.valueOf(currentBalance);
                } else if (type.equalsIgnoreCase("WITHDRAW")) {
                    if (amount > currentBalance) {
                        // Saldo tidak mencukupi -> Transaksi gagal, masukkan ke Stack
                        failedTransactions.push(tx);
                    } else {
                        currentBalance -= amount;
                        targetCustomer[1] = String.valueOf(currentBalance);
                    }
                }
            }
        }

        // 5. Cetak Output sesuai spesifikasi modul
        System.out.println("=== Final Balances ===");
        for (String[] cust : customers) {
            System.out.println(cust[0] + ": " + cust[1]);
        }

        System.out.println("=== Failed Transactions ===");
        while (!failedTransactions.isEmpty()) {
            String[] failed = failedTransactions.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
    }
}