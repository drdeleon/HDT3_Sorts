// B. Duane (2017) Java Structures.

public class MergeSort  {

    public static void merge (Comparable[] data, Comparable[] temp, int low, int middle, int high)
            //pre: data [middle..high] are ascending.
            //  temp[low..high] are ascending.
            //post: data[low..high] contains all values in ascending oder.
    {
        int ri = low; //result index
        int ti = low; //temp index
        int di = middle; // destination index.
        // while (ti< middle && di <= high)
        while (ti < middle && di <= high) {
            if (data[di].compareTo(temp[ti]) < 0) {
                data[ri++] = data[di++]; // smaller is in high data
            } else {
                data[ri++] = temp[ti++]; //smaller is in temp.
            }
        }
            // possible some values left in temp array.
            while (ti < middle) {
                data[ri++] = temp[ti++];
            }
            // ...or some values left (in correct place) in data array.
        }

    private static  void mergeSortRecursive (Comparable[] data, Comparable[] temp, int low, int high) {
        // pre: 0 <= low <= high < data.length
        // post: values in data [low..high] are in ascending order

        int n = high - low + 1;
        int middle = low + n / 2;
        int i;

        if (n < 2) return;
        //move lower half of data into temporary storage.
        for (i = low; i < middle; i++) {
            temp[i] = data[i];
//
        }
        // sort lower half of array
        mergeSortRecursive(temp, data, low, middle-1);

        //sort upper half of array.
        mergeSortRecursive(data,temp,middle,high);

        //merge halves together.
        merge(data, temp, low, middle, high);
    }

    public static void mergeSort (Comparable[] data, int n){
        // pre: 0 <= n <= data.length
        // post: values in data[0..n-1] are in ascending order

        mergeSortRecursive(data, new Comparable[n], 0, n-1);

    }
}
