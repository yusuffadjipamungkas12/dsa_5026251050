import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        soal1();
        soal2();
        soal3();
    }

    // soal 1 - playlist
    static void soal1() {
        ArrayList<String> lagu = new ArrayList<>();

        
            Scanner sc = new Scanner(new File("playlist.txt"));
            while (sc.hasNextLine()) {
                String baris = sc.nextLine().trim();
                if (baris.length() == 0) continue;

                String[] kata = baris.split("\\s+", 2);
                String perintah = kata[0];

                switch (perintah) {
                    case "ADD":
                        lagu.add(kata[1]);
                        break;
                    case "INSERT":
                        String[] sisa = kata[1].split("\\s+", 2);
                        int posisi = Integer.parseInt(sisa[0]);
                        lagu.add(posisi, sisa[1]);
                        break;
                    case "REMOVE":
                        lagu.remove(kata[1]);
                        break;
                }
            }
            sc.close();
       
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + lagu.size());
        int no = 1;
        for (String l : lagu) {
            System.out.println(no + ": " + l);
            no++;
        }
    }

    // soal 2 - peserta workshop
    static void soal2() {
        Set<String> peserta = new LinkedHashSet<>();
        int ganda = 0;

        try {
            Scanner sc = new Scanner(new File("participants.txt"));
            while (sc.hasNextLine()) {
                String nama = sc.nextLine().trim();
                if (nama.isEmpty()) continue;

                boolean baru = peserta.add(nama);
                if (!baru) ganda++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("participants.txt tidak ada");
            return;
        }

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + peserta.size());
        int urut = 1;
        for (String p : peserta) {
            System.out.println(urut + ". " + p);
            urut++;
        }
        System.out.println("Duplicate registrations: " + ganda);
    }

    // soal 3 - stok produk
    static void soal3() {
        Map<String, Integer> stok = new LinkedHashMap<>();
        int gagal = 0;

        try {
            Scanner sc = new Scanner(new File("inventory.txt"));
            while (sc.hasNextLine()) {
                String baris = sc.nextLine().trim();
                if (baris.isEmpty()) continue;

                String[] data = baris.split("\\s+");
                String aksi = data[0];
                String barang = data[1];
                int jumlah = Integer.parseInt(data[2]);

                if (aksi.equals("ADD")) {
                    int lama = stok.containsKey(barang) ? stok.get(barang) : 0;
                    stok.put(barang, lama + jumlah);
                } else if (aksi.equals("SELL")) {
                    if (stok.containsKey(barang) && stok.get(barang) >= jumlah) {
                        stok.put(barang, stok.get(barang) - jumlah);
                    } else {
                        gagal++;
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("inventory.txt tidak ada");
            return;
        }

        System.out.println("===== Problem 3 =====");
        for (String barang : stok.keySet()) {
            System.out.println(barang + ": " + stok.get(barang));
        }
        System.out.println("Failed sales: " + gagal);
    }
}