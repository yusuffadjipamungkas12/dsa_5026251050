public class Main {

    public static void main(String[] args) {

        int data [] = {100, -2, 99, -99, 2, 22, 1, 3, 4, -1, 5, 1000};
        Sorting m = new Sorting(data);
        System.out.println("Sebelum Merge Sort:");
        System.out.println(m);

        System.out.println("Test Merge Sort:");
        m.mergeSort();
        System.out.println(m);

        System.out.println("Reverse:");
        m.reverse();
        System.out.println(m);

        m.reverse();
        int k = 99;

        System.out.println("Linear Search:");
        int id = m.linearSearch(k);
        if(id==-1) System.out.println(k+ " is not found");
        else System.out.println(k+ " is found at index "+ id);

        System.out.println("Binary Search:");
        id = m.binarySearch(k);
        if(id==-1) System.out.println(k+ " is not found");
        else System.out.println(k+ " is found at index "+ id);
    }
}