
import java.lang.*;
import java.util.*;

class main {
    public static void main(String[] args) {
        int[] data = {9, 7, 6, 3, 2, 1, 10, 14}; 
        
        System.out.print("Data sebelum diurutkan: ");
        for (int d : data) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.print("Data setelah diurutkan: ");
        selectSort(data); 
    }

    // public static void bubleSort(int[] data) {
    //     int n = data.length;
            // -- a = 0 to n-1
    //     for (int a = 0; a < n - 1; a++) { 
                // b = 0 to n - a - 1
    //         for (int b = 0; b < n - a - 1; b++) {
    //             if (data[b] < data[b + 1]) {
    //                 int temp = data[b]; 
    //                 data[b] = data[b + 1]; 
    //                 data[b + 1] = temp; 
    //             }
    //         }
    //     }
    //     for (int d : data) {
    //     System.out.print(d + " ");
    //     }
    //}
    public static void selectSort(int[]data){
        int n = data.length;

        for(int i = 0; i < n-1; i++){
            int minIdx = i; 
            for(int j = i+1; j < n-1; j++){
                if(data [j] < data [minIdx]){
                    minIdx = j; 
                }
            }
            int temp = data[i]; 
            data[i] = data [minIdx];
            data [minIdx] = temp;  
        }
        for (int d : data) {
        System.out.print(d + " ");
        }
    }
}