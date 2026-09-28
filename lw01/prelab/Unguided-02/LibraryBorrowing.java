import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LibraryBorrowing {
    public static void main(String[] args) {
        //LinkedList untuk menampung seluruh request
        LinkedList<String[]> rawRequests = new LinkedList<>();

        // LinkedList untuk buku dan stok awal
        LinkedList<String[]> books = new LinkedList<>();
        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        // LinkedList untuk member dan jumlah pinjaman
        LinkedList<String[]> members = new LinkedList<>();

        // baca file borrowing.txt
        try {
            File file = new File("borrowing.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Format: <NAME> <BOOK_TITLE>
                String[] parts = line.split("\\s+");
                rawRequests.add(parts);

                // Tambahkan member ke list 
                String memberName = parts[0];
                boolean memberExists = false;
                for (String[] m : members) {
                    if (m[0].equals(memberName)) {
                        memberExists = true;
                        break;
                    }
                }

                if (!memberExists) {
                    members.add(new String[]{memberName, "0"});
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File borrowing.txt tidak ditemukan!");
            return;
        }

        // Pindahkan semua request dari LinkedList ke Queue (FIFO)
        Queue<String[]> requestQueue = new LinkedList<>();
        for (String[] req : rawRequests) {
            requestQueue.add(req);
        }

        // LinkedList untuk menampung request yang berhasil
        LinkedList<String[]> successfulRequests = new LinkedList<>();

        // 4. Stack untuk menampung request yang gagal (LIFO)
        Stack<String[]> failedRequests = new Stack<>();

        final int MAX_BORROW = 2;

        // Memproses request di dalam Queue sampai kosong
        while (!requestQueue.isEmpty()) {
            String[] req = requestQueue.poll();
            String name = req[0];
            String bookTitle = req[1];

            // Cari data member
            String[] targetMember = null;
            for (String[] m : members) {
                if (m[0].equals(name)) {
                    targetMember = m;
                    break;
                }
            }

            // Cari data buku
            String[] targetBook = null;
            for (String[] b : books) {
                if (b[0].equals(bookTitle)) {
                    targetBook = b;
                    break;
                }
            }

            // Validasi stok buku dan batas pinjam member
            if (targetMember != null && targetBook != null) {
                int stock = Integer.parseInt(targetBook[1]);
                int borrowed = Integer.parseInt(targetMember[1]);

                if (stock > 0 && borrowed < MAX_BORROW) {
                    // Berhasil: kurangi stok, tambah pinjaman, catat ke list berhasil
                    targetBook[1] = String.valueOf(stock - 1);
                    targetMember[1] = String.valueOf(borrowed + 1);
                    successfulRequests.add(req);
                } else {
                    // Gagal: masukkan ke stack
                    failedRequests.push(req);
                }
            }
        }

        // 5. Menampilkan output sesuai format exact behaviour
        System.out.println("=== Successfully Processed Requests ===");
        for (String[] req : successfulRequests) {
            System.out.println(req[0] + " " + req[1]);
        }

        System.out.println("=== Remaining Book Stock ===");
        for (String[] b : books) {
            System.out.println(b[0] + " : " + b[1]);
        }

        System.out.println("=== Failed Requests ===");
        while (!failedRequests.isEmpty()) {
            String[] failed = failedRequests.pop();
            System.out.println(failed[0] + " " + failed[1]);
        }
    }
}