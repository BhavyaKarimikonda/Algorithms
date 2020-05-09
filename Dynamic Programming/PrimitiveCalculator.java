import java.util.*;
import java.lang.*;

public class PrimitiveCalculator {
    
    private static List<Integer> optimal_seq(int n) {
        int[] a = new int[n+1];
        a[0] = 0;
        for(int i=1 ; i<=n ; i++){
            a[i] = Integer.MAX_VALUE;
            if(i%3 == 0)
                a[i] = a[i/3] + 1;
            if(i%2 == 0)
                if(a[i/2] + 1 < a[i])
                    a[i] = a[i/2] + 1;
            if(a[i-1]+1 < a[i])
                a[i] = a[i-1] + 1;
        }
        
        List<Integer> seq = new ArrayList<Integer>();
        
        while(n > 0) {
            seq.add(n);
            List<Integer> seq2 = new ArrayList<Integer>();
            if (n % 3 == 0) 
                seq2.add(n/3);
            if (n % 2 == 0)
                seq2.add(n/2);
            seq2.add(n-1);
            int getlen = Integer.MAX_VALUE;
            for(Integer i: seq2){             
                if(a[i] <= getlen){
                    getlen = a[i];
                    n = i ;
                }
            }
        }
        Collections.reverse(seq);
        return seq;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> seq = optimal_seq(n);
        System.out.println(seq.size() - 1);
        for (Integer x : seq) {
            System.out.print(x + " ");
        }
    }
}

