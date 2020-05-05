import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        double[] perunit = new double[values.length];
        for(int i=0; i<values.length; i++){
            perunit[i] = (double)values[i]/weights[i];
        }
        int maxIndex = findMaxIndex(perunit);
        while(capacity > 0 && perunit[maxIndex] > 0){
            
                if(weights[maxIndex] < capacity){
                    capacity -=  weights[maxIndex];
                    value += values[maxIndex];
                    perunit[maxIndex] = -1;
                }
                else{
                    value += perunit[maxIndex]*(capacity);
                    capacity = 0;
                }
                maxIndex = findMaxIndex(perunit);
        }
        return value;
    }
    
    public static int findMaxIndex(double[] arr){
        int maxIndex = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[maxIndex] ){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
