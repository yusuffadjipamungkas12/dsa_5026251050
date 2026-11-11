

class Sorting{
    int data [];
    
    Sorting(int []a){
        this.data = a;
    }
       public String toString(){
        String output="";
        for(int d:data) output+=" "+d;
        return output;
    }

    void mergeSort(){
        split(this.data, 0, this.data.length - 1);
    }
        // Split the array into two subarrays, sort them and merge them
    void split(int arr[], int l, int r) {
    if (l < r) {

      // m is the point where the array is divided into two subarrays
      int m = (l + r) / 2;

      split(arr, l, m);
      split(arr, m + 1, r);

      // Merge the sorted subarrays
      merge(arr, l, m, r);
    }
  }
  
  // Merge two subarrays L and M into arr
  void merge(int arr[], int p, int q, int r) {

    int n1 = q - p + 1;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    for (int i = 0; i < n1; i++)
      L[i] = arr[p + i];
    for (int j = 0; j < n2; j++)
      M[j] = arr[q + 1 + j];

    // Maintain current index of sub-arrays and main array
    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    // Until we reach either end of either L or M, pick larger among
    // elements L and M and place them in the correct position at A[p..r]
    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = M[j];
        j++;
      }
      k++;
    }

    // When we run out of elements in either L or M,
    // pick up the remaining elements and put in A[p..r]
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = M[j];
      j++;
      k++;
    }
  }

    void reverse(){
        int r [] = new int[this.data.length];
        int l = this.data.length-1;

        //your code goes here
        for (int i = 0; i < this.data.length; i++) {
            r[i] = this.data[l - i];
        }

        this.data = r;
    }

    int linearSearch(int k){
        return linearSearch(k,0);
    }

    int linearSearch(int k, int i){
        //base case
        if(i == this.data.length){
            //your code goes here
            return -1;
        }
        //recursive step
        else if(this.data[i]==k){
            //your code goes here
            return i;
        }
        else{
            //your code goes here
            return linearSearch(k, i + 1);
        }
    }

    int binarySearch(int k){
        return binarySearch(k, 0, this.data.length-1);
    }

    int binarySearch(int k, int l, int h){
        //base case
        if(l>h) return -1;

        //recursive step
        else{
            int m = (l+h)/2;
            int v = this.data[m];

            //your code goes here
            if (v == k) return m;
            else if (v < k) return binarySearch(k, m + 1, h);
            else return binarySearch(k, l, m - 1);
        }
    }

    
}