import java.util.Scanner;

public class RidTimeHop {

    public static void insertionSortDesc(int[] data, int passes) {
        for (int i = 1; i <= passes && i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] < key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(RidTimeHop.class.getResourceAsStream("/branches.txt"));

        int n = sc.nextInt();
        int[] branches = new int[n];
        for (int i = 0; i < n; i++) {
            branches[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        insertionSortDesc(branches, 3);

        for (int i = 0; i < n; i++) {
            System.out.print(branches[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int idx = linearSearch(branches, targets[i]);
            if (idx == -1) {
                System.out.println(targets[i] + ": NOT FOUND");
            } else {
                System.out.println(targets[i] + ": FOUND at index " + idx);
            }
        }
    }
}