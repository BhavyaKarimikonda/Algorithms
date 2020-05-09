import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    public static long mergeSort(int[] arr, int left, int right) {
        if (left == right)
            return 0;
        long result = 0;
        int mid = (left + right) / 2;
        result = result + mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right) + merge(arr, left, right);
        return result;
    }

    public static long merge(int[] arr, int left, int right) {
        long count = 0;
        int mid = (left + right) / 2;
        int[] mergedarr = new int[right - left + 1];
        int curr = 0;
        int i = left, j = mid + 1;
        
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                mergedarr[curr++] = arr[j++];
                count += mid - i + 1;
            } 
            else 
                mergedarr[curr++] = arr[i++];
        }
        while (i <= mid) 
            mergedarr[curr++] = arr[i++];
        while (j <= right) 
            mergedarr[curr++] = arr[j++];
            
        System.arraycopy(mergedarr, 0, arr, left, right - left + 1);
        return count;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(getNumberOfInversions(a));
    }
}