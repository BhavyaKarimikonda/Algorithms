import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stop) {
        int last=0, current=0, num = 0;
        
        int[] stops = new int[stop.length+2];
        stops[0] = 0;
        for(int i=1; i<stop.length+1; i++){
            stops[i] = stop[i-1];
        }
        stops[stop.length] = dist ;
        
        int n = stops.length;
        if(tank < dist){
            while(current <= n-2){
                last = current;
                while(current <= n-2 && stops[current + 1] - stops[last] <= tank){
                    current = current + 1;
                }
                if(current == last){
                    return -1;
                }
                if(current <= n-2){
                    num++ ;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
