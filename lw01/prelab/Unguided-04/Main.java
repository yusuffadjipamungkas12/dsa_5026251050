import java.util.Scanner;

public class Main {

    public static void sortCards(int[] data, int passes) {
        int n = data.length;

        for (int i = 0; i < passes; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIdx];
            data[minIdx] = temp;
        }
    }

    public static int findCard(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("/cards2.txt"));

        int n = sc.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] asked = new int[m];
        for (int i = 0; i < m; i++) {
            asked[i] = sc.nextInt();
        }

        sortCards(cards, 2);

        for (int i = 0; i < n; i++) {
            System.out.print(cards[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int idx = findCard(cards, asked[i]);
            if (idx == -1) {
                System.out.println(asked[i] + ": NOT FOUND");
            } else {
                System.out.println(asked[i] + ": FOUND at index " + idx);
            }
        }
    }
}